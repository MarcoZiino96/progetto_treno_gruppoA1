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

		return "redirect:/login";
	}
}



