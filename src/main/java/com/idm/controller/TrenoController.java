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
import org.springframework.web.bind.annotation.RequestMapping;

import com.idm.entity.Treno;
import com.idm.service.TrenoService;
import com.idm.vo.TrenoVO;


	@Controller	
	public class TrenoController {
		
		
		@Autowired
		private TrenoService trenoService;
				
	    @GetMapping ("/home")
	    public String home(Model model) {
//	    	List<Treno> treni = trenoService.retrive();
	    	List<TrenoVO> treni = trenoService.getTreniVO();
	    	 System.out.println("Numero di treni recuperati: " + treni.size()); //
	    	model.addAttribute("treni", treni);
	    	System.out.println("home");
	        return "home"; // Cerca il file home.jsp in /WEB-INF/jsp/
	    }
	    

		

		

	}



