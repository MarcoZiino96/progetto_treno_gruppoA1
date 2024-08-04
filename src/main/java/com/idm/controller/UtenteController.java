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

import com.idm.entity.Utente;
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
		 Utente usernameUtente = utenteService.findByUsername(utenteVo.getUsername());
		 Utente emailUtente = utenteService.findByEmail(utenteVo.getEmail());
		   
		    if (emailUtente != null || usernameUtente != null ) {
		        bindingResult.rejectValue("email", "error.email", "Email già esistente");
		        bindingResult.rejectValue("username", "error.username", "Username già esistente");
		        return "preRegister";
		    }  
	    try {
	        utenteService.createUtente(utenteVo);
	        
	    } catch (Exception e) {
	        return "preRegister";
	    }

	    return "redirect:/login";
	}
	@Autowired
	private UtenteService utenteService;

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
		List<Utente> listaUtenti = utenteService.searchByUsername(username);
		if (listaUtenti.isEmpty()) {
			model.addAttribute("error", "Nessun utente registrato");
			return "formlogin";
		} else {
			for (Utente ut : listaUtenti) {
				if (ut.getPassword().equals(password)) {
					session.setAttribute("Loggato", "SI");
					session.setAttribute("utente", ut);    
					model.addAttribute("message", "ciao " + username); 
					return "message";
				} else {
					model.addAttribute("error", "Password sbagliata");
					return "formlogin";
				}
			}
		}    
		return "message";
	}

	@PostMapping("/logout")
	public String logout(HttpSession session,Model model) {
		session.invalidate();
		model.addAttribute("message", "Sei stato disconnesso con successo.");
		return "redirect:/login";
	}
}







