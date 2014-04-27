package com.tcc.viralata;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcc.viralata.dao.UsuarioDAO;
import com.tcc.viralata.model.Cidade;
import com.tcc.viralata.model.Endereco;
import com.tcc.viralata.model.Status;
import com.tcc.viralata.model.Usuario;
import com.tcc.viralata.utils.ConstantsViraLata;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	UsuarioDAO usuarioDao = new UsuarioDAO();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "login";
	}
	
	@RequestMapping(value = "/dadosCadastraisAdoTela", method = RequestMethod.GET)
	public String dadosCadastraisAdoTela(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "dadosCadastraisAdo";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/telaCadastroUsuario", method = RequestMethod.POST)
	public String telaCadastroUsuario(Locale locale, Model model) {
		
		return "cadastro";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String cadastro(HttpServletRequest request, Model model) {
		
		String nome = request.getParameter("nome");
		String cpfCnpj = request.getParameter("cpfCnpj");
		String rg = request.getParameter("rg");
		String email = request.getParameter("email");
		String dtNasc = request.getParameter("dtNasc");
		String usuario = request.getParameter("login");
		String senha = request.getParameter("senha");
		String tel = request.getParameter("tel");
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		String cidade = request.getParameter("cidade");

		Usuario usuarioRequest = new Usuario();
		Endereco endereco = new Endereco();
		Cidade cidadeObj = new Cidade();
		
		usuarioRequest.setNome(nome);
		usuarioRequest.setCpfCnpj(cpfCnpj);
		usuarioRequest.setRg(rg);
		usuarioRequest.setEmail(email);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			usuarioRequest.setDataNascimento(sdf.parse(dtNasc));
		} catch (ParseException e) {
			System.err.println("Erro na conversao da data");
			e.printStackTrace();
		}
		usuarioRequest.setLogin(usuario);
		usuarioRequest.setSenha(senha);
		usuarioRequest.setTipoAcesso(ConstantsViraLata.TIPO_ACESSO_ADOTANTE);
		
		endereco.setTelefoneResidencial(tel);
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setRua(rua);
		endereco.setNumero(Integer.valueOf(numero));
		
		cidadeObj.setIdCidade(Integer.valueOf(cidade));
		
		Status status = usuarioDao.cadastraUsuario(usuarioRequest, endereco, cidadeObj);
		model.addAttribute("statusCadastro", status.getStatus());
		model.addAttribute("usuario", usuarioRequest);
		model.addAttribute("endereco",endereco);
		model.addAttribute("dtNasc",sdf.format(usuarioRequest.getDataNascimento()));
		
		return "cadastro";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String usuario, String senha, Model model, HttpServletRequest request) throws ClassNotFoundException {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuarioRequest = usuarioDao.login(usuario, senha);
		if (ConstantsViraLata.TIPO_ACESSO_ADMINISTRADOR.equals(usuarioRequest.getTipoAcesso())){
			return "homeAdm";
		}else if (ConstantsViraLata.TIPO_ACESSO_ADOTANTE.equals(usuarioRequest.getTipoAcesso())){
			return "homeAdo";
		}
		model.addAttribute("statusLogin", usuarioRequest.getStatus());
		model.addAttribute("usuarioDigitado",usuario);
		return "login";

		
	}
	
	
}
