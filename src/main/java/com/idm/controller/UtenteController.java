package com.idm.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.idm.entity.Utente;
import com.idm.service.UtenteService;
import com.idm.vo.UtenteVO;
import com.idm.vo.UtenteVoLogin;

@Controller
public class UtenteController {

	@Autowired
	UtenteService utenteService;

	@GetMapping("/formlogin")
	public String login(@ModelAttribute("utente") UtenteVoLogin utenteVoLogin, Model model ) {
		
		model.addAttribute("message", "benvenuto nel login");
		return "formlogin";
	}


	@GetMapping("/preRegister")
	public String showRegister(@ModelAttribute("utente") UtenteVO utenteVo) {

		return "preRegister";
	}

	@PostMapping("/postRegister")
	public String registerUser(@Valid @ModelAttribute("utente") UtenteVO utenteVo, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "preRegister";     
		}
		Utente usernameUtente = utenteService.findByUsername(utenteVo.getUsername());
		Utente emailUtente = utenteService.findByEmail(utenteVo.getEmail());

		if(emailUtente != null &&  usernameUtente != null) {
			bindingResult.rejectValue("email", "error.email", "Email già esistente");
			bindingResult.rejectValue("username", "error.username", "Username già esistente");
			return "preRegister";

		}

		if (emailUtente != null) {
			bindingResult.rejectValue("email", "error.email", "Email già esistente");
			return "preRegister";
		}

		if(usernameUtente != null) {
			bindingResult.rejectValue("username", "error.username", "Username già esistente");
			return "preRegister";
		}

		try {
			utenteService.createUtente(utenteVo);

		} catch (Exception e) {
			return "preRegister";
		}

		return "formlogin";
	}

	@PostMapping("/formlogin")
	public String login(@Valid @ModelAttribute("utente") UtenteVoLogin utenteVoLogin, 
	                    BindingResult bindingResult, HttpSession session) {

		System.out.println("Username inserito: " + utenteVoLogin.getUsername());
	    System.out.println("Password inserita: " + utenteVoLogin.getPassword());
	    
	    if (bindingResult.hasErrors()) {
	        return "formlogin"; 
	    }
	    
	    Utente utente = utenteService.findByUsername(utenteVoLogin.getUsername());

	    if (utente == null) {
	        bindingResult.rejectValue("username", "error.username", "L'username non esiste");
	        return "formlogin";
	    }
	    System.out.println("Password memorizzata: " + utente.getPassword());

	    
	    if (!utente.getPassword().equals(utenteVoLogin.getPassword())) {
	        bindingResult.rejectValue("password", "error.password", "Password errata");
	        return "formlogin";
	    }

	   try {
		   session.setAttribute("utente", utente);
		    
	   }catch (Exception e) {
		   System.out.println("Errore durante l'impostazione della sessione: " + e.getMessage());
			return "preRegister";
		}

	   return "home";
	    
	}


	@PostMapping("/logout")
	public String logout(HttpSession session,Model model) {
		session.invalidate();
		model.addAttribute("message", "Sei stato disconnesso con successo.");
		return "redirect:/formlogin";
	}

	@GetMapping("/header")
	public String showHeader(UtenteVoLogin utenteVo) {
		
		return "header";
	}
	
//	@GetMapping("/footer")
//	public String showFooter(UtenteVoLogin utenteVo) {
//		
//		return "footer";
//	}

}







