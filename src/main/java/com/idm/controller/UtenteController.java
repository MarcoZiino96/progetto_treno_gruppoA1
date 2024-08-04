package com.idm.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.idm.service.UtenteService;
import com.idm.vo.UtenteVO;
import antlr.StringUtils;



@Controller
public class UtenteController {

	@Autowired
	UtenteService utenteService;

	@GetMapping("/login")
	public String login(Model model ) {
		model.addAttribute("message", "benvenuto nel login");
		return "login";
	}

	@GetMapping("/preRegister")
	public String showRegister(Model model) {
		model.addAttribute("utente", new UtenteVO());
		return "preRegister";
	}




	@PostMapping("/postRegister")
	public String registerUser(@Valid @ModelAttribute("utente") UtenteVO utenteVo, BindingResult bindingResult, Model model) {
	    
		if (bindingResult.hasErrors()) {
	        return "preRegister";     
	    }
		
	    try {
	        utenteService.createUtente(utenteVo);
	        
	    } catch (Exception e) {
//	        model.addAttribute("errorMessage", "La data è obbligatoria");
	        return "preRegister";
	    }

	    return "redirect:/login";
	}
}




//@PostMapping("/register")
//public String registerUser(@ModelAttribute("utente") Utente utente, Model model) {
//  
//	System.out.println("Registrazione completata, redirezionamento a /login");
//	try {
//      //System.out.println("Utente ricevuto per registrazione: " + utente.toString());
//      //utenteService.createUtente(utente);
//      System.out.println("Registrazione completata, redirezionamento a /login");
//      return "redirect:/login";
//      
//  } catch (Exception e) {
//      e.printStackTrace();
//      model.addAttribute("errorMessage", "Errore durante la registrazione: " + e.getMessage());
//      return "register";
//  }
//}


