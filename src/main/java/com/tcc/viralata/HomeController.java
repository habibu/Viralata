package com.tcc.viralata;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcc.viralata.dao.UsuarioDAO;
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
	public String cadastro(String nome, String cpfCnpj, String rg, String email, String dataNasc, String bairro, String cep, String rua, String numero, String cidade, String estado, String tel, String cel) {
		
		System.out.println("Ok");
		
		
		return "cadastro";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String login, String senha) throws ClassNotFoundException {
		try {
			UsuarioDAO usuarioDao = new UsuarioDAO();
			Usuario usuario = usuarioDao.login(Integer.valueOf(login), senha);
			if (ConstantsViraLata.TIPO_ACESSO_ADMINISTRADOR.equals(usuario.getTpAcesso())){
				return "homeAdm";
			}else if (ConstantsViraLata.TIPO_ACESSO_ADOTANTE.equals(usuario.getTpAcesso())){
				return "homeAdo";
			}
		}catch(Exception e){
			System.out.println("Erro no login");
			return "login";
		}
		return "login";

		
	}
	
	
}
