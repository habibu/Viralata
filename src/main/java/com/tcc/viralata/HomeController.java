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
import com.tcc.viralata.model.Adotante;
import com.tcc.viralata.model.Cidade;
import com.tcc.viralata.model.Endereco;
import com.tcc.viralata.model.Usuario;
import com.tcc.viralata.utils.ConstantsViraLata;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastro(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "cadastro";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String cadastro(HttpServletRequest request) {
		
		String nome = request.getParameter("nome");
		String cpfCnpj = request.getParameter("cpfCnpj");
		String rg = request.getParameter("rg");
		String email = request.getParameter("email");
		String dtNasc = request.getParameter("dtNasc");
		String tel = request.getParameter("tel");
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
//		String tipoMoradia = request.getParameter("tipoMoradia");
//		String area = request.getParameter("area");
//		String renda = request.getParameter("renda");
//		String filhos = request.getParameter("filhos");
//		String animais = request.getParameter("animais");

		Usuario usuario = new Usuario();
//		Adotante adotante = new Adotante();
		Endereco endereco = new Endereco();
		Cidade cidadeObj = new Cidade();
		
		usuario.setNome(nome);
		usuario.setCpfCnpj(cpfCnpj);
		usuario.setRg(rg);
		usuario.setEmail(email);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			usuario.setDataNascimento(sdf.parse(dtNasc));
		} catch (ParseException e) {
			System.err.println("Erro na conversao da data");
			e.printStackTrace();
		}
		usuario.setTipoAcesso(ConstantsViraLata.TIPO_ACESSO_ADOTANTE);
		
		endereco.setTelefoneResidencial(tel);
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setRua(rua);
		endereco.setNumero(Integer.valueOf(numero));
		
		cidadeObj.setEstado(estado);
		cidadeObj.setNome(cidade);
		
		return "cadastro";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String login, String senha) throws ClassNotFoundException {
		try {
			UsuarioDAO usuarioDao = new UsuarioDAO();
			Usuario usuario = usuarioDao.login(login, senha);
			if (ConstantsViraLata.TIPO_ACESSO_ADMINISTRADOR.equals(usuario.getTipoAcesso())){
				return "homeAdm";
			}else if (ConstantsViraLata.TIPO_ACESSO_ADOTANTE.equals(usuario.getTipoAcesso())){
				return "homeAdo";
			}
		}catch(Exception e){
			System.out.println("Erro no login");
			return "login";
		}
		return "login";

		
	}
	
	
}
