package com.idm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.service.TrenoService;
import com.idm.vo.TrenoVO;
import com.idm.vo.UtenteVO;


	@Controller	
	public class TrenoController {
		
		@Autowired
		private TrenoService trenoService;
		
		@GetMapping("/home")
		public String showHome(@ModelAttribute("treno") TrenoVO trenoVo){
			return "home";
		}
		
		
//		@PostMapping("/newTrain")
//		public String creaTreno(@ModelAttribute("treno") TrenoVO trenoVo,HttpSession session,Model model){
//			
//			
//			
//		}
		
		
				
		@GetMapping("/order")
		public String ordina(
		                     @RequestParam(required = false) String ordinamento,
		                     @RequestParam(required = false) String direction,
		                     Model model) {

		    if (ordinamento == null || ordinamento.isEmpty()) {
		        ordinamento = "compagnia"; 
		    }
		    if (direction == null || direction.isEmpty()) {
		        direction = "ASC"; 
		    }

		
		    List<TrenoVO> treni = trenoService.retriveWithOrderVO(ordinamento, direction);
		    
		    model.addAttribute("treni",treni);
		    model.addAttribute("ordinamento", ordinamento); 
		    model.addAttribute("direction", direction); 
		    return "order"; 
		}

	}



