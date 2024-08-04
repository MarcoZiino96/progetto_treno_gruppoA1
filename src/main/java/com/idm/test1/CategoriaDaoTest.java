package com.idm.test1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.service.TrenoService;

public class CategoriaDaoTest {


	@Autowired
	private static TrenoService  trenoService ;

	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        trenoService = context.getBean(TrenoService.class);

		Treno  treno1 = new Treno("TN", "foto1","HPPPP", 30.0, 5.0, 5.4 );
		Treno  treno2= new Treno("FR", "foto2","HPPPPPR", 50.0, 8.0, 4.4 );
		Treno  treno3= new Treno("IT", "foto3","HPP", 40.0, 6.0, 2.0 );
		Treno  treno4= new Treno("TN", "foto4","HCCCC", 60.0, 5.3, 1.2 );
		Treno  treno5= new Treno("FR", "foto5","HRPP", 34.0, 5.4, 1.8 );
		Treno  treno6= new Treno("IT", "foto6","HCCC", 31.0, 6.1, 1.4 );

//		Treno  treno1 = new Treno(1.4, 5.0, 30.0, "TN", "x");
//		Treno  treno2= new Treno(1.4, 5.0, 30.0, "TN", "x");
//		Treno  treno3= new Treno(1.4, 5.0, 30.0, "TN", "x");
//		Treno  treno4= new Treno(1.4, 5.0, 30.0, "TN", "x");
//		Treno  treno5= new Treno(1.4, 5.0, 30.0, "TN", "x");
//		Treno  treno6= new Treno(2.4, 7.0, 32.0, "TN", "x");

				
		trenoService.createTreno(treno1);
		trenoService.createTreno(treno2);
		trenoService.createTreno(treno3);
		trenoService.createTreno(treno4);
		trenoService.createTreno(treno5);
		trenoService.createTreno(treno6);
		
		
//		treno1.setLunghezza(40.0);
//		treno2.setLunghezza(25.0);
//		treno3.setLunghezza(50.0);
//		treno4.setLunghezza(42.0);
//		treno5.setLunghezza(33.0);
//		treno6.setLunghezza(12.0);
//		
//		treno1.setPeso(50.0);
//		treno2.setPeso(35.0);
//		treno3.setPeso(51.0);
//		treno4.setPeso(41.0);
//		treno5.setPeso(31.0);
//		treno6.setPeso(11.0);
//		
//
//		trenoService.update(treno1, 1);
//		trenoService.update(treno2, 2);
//		trenoService.update(treno3, 3);
//		trenoService.update(treno4, 4);
//		trenoService.update(treno5, 5);
//		trenoService.update(treno6, 6);
		
		
//		List<Treno> treniOrdinati = trenoService.retriveWithOrder("peso", "ASC");
//		for (Treno el : treniOrdinati) {
//		    System.out.println(el);
//		}
		
//		List<Treno> treniOrdinati = trenoService.retriveWithOrder("lunghezza", "ASC");
//		for (Treno el : treniOrdinati) {
//		    System.out.println(el);
//		}
		
//		List<Treno> treniOrdinati = trenoService.retriveWithOrder("sigla", "ASC");
//		for (Treno el : treniOrdinati) {
//		    System.out.println(el);
//		}
		
		TrenoFilter filter = new TrenoFilter();
//        filter.setPrezzoMin(0);
//        filter.setPrezzoMax(2);
        filter.setPesoMin(5);
        filter.setPesoMax(20);
//        filter.setLunghezzaMin(10);
//        filter.setLunghezzaMax(30);
//        filter.setSiglaContains("FA");
//        filter.setUtente("utente1");

        List<Treno> filteredTreni = trenoService.findByFilter(filter);
        filteredTreni.forEach(System.out::println);
        
	}
	
	

	
	
	
	
	public static void creaTreno(Treno treno) {
		trenoService.createTreno(treno);
	}
	
	public static void updateTreno(Treno treno, int id) {
		trenoService.update(treno, id);
	}
	
}
