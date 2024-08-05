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
import org.springframework.web.bind.annotation.RequestParam;

import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.service.TrenoService;
import com.idm.vo.TrenoVO;


	@Controller	
	public class TrenoController {
		
		@Autowired
		private TrenoService trenoService;
				
	    @GetMapping ("/home")
	    public String home(Model model) {
	        return "home"; 
	    }
//	    
//	    @GetMapping("/home")
//	    public String search(@RequestParam(required = false) String termineRicerca,
//	                       Model model) {
//	        
//	        TrenoFilter filter = new TrenoFilter();
//	        filter.setTermineRicerca(termineRicerca);
//	        
//	        List<TrenoVO> treni = trenoService.searchTreni(filter);
//	        model.addAttribute("treni", treni);
//	        return "home";
//	    }
//	    
//	}

//	    @GetMapping("/search")
//	    public String search(@RequestParam(required = false) String termineRicerca, Model model) {
//	        List<TrenoVO> treni;
//	        
//	        if (termineRicerca != null && !termineRicerca.isEmpty()) {
//	            TrenoFilter filter = new TrenoFilter();
//	            filter.setTermineRicerca(termineRicerca);
//	            treni = trenoService.searchTreni(filter);
//	        } else {
//	            treni = trenoService.getTreniVO();
//	        }
//
//	        model.addAttribute("treni", treni);
//	        return "search"; // Cerca il file search.jsp in /WEB-INF/jsp/
//	    }

		

		

	}



