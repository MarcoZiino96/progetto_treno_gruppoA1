package com.idm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.idm.entity.Utente;
import com.idm.service.UtenteService;
import com.idm.vo.UtenteVoLogin;

@Controller
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	@GetMapping("/")
	public String showForm(UtenteVoLogin utenteVo) {
		return "formlogin";
	}

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
		return "redirect:/";
	}
}
