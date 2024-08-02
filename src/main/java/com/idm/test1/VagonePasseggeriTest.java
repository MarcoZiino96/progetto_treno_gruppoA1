package com.idm.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.entity.Treno;
import com.idm.entity.VagonePasseggeri;
import com.idm.service.TrenoService;
import com.idm.service.VagoneCargoService;
import com.idm.service.VagonePasseggeriService;

//public class VagonePasseggeriTest {
//
//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(com.idm.config.Beans.class);
//	
//	private  VagonePasseggeriService vagonePasseggeriService = applicationContext.getBean(VagonePasseggeriService.class);
//
//	
//	public static void main(String[] args) {
//		//testFindUtenti();
//		//testCreaAggiornaEliminaTreno();
//		//testCreaAggiornaEliminaLocomotiva();
//		VagonePasseggeri vagonePasseggeri = new VagonePasseggeri(1000,1000, 0, 0, null);
//		vagonePasseggeriService.creaVagonePasseggeri(vagonePasseggeri);
//
//
//	}
//	
//	public  void creaVagonePasseggeri(VagonePasseggeri vagonePasseggeri) {
//		vagonePasseggeriService.creaVagonePasseggeri(vagonePasseggeri);
//	}
//}
