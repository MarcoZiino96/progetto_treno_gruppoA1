package com.idm.test1;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.dao.UtenteDao;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.entity.Utente;
import com.idm.service.TrenoService;


public class CategoriaDaoTest {


	@Autowired
	private static TrenoService  trenoService ;

	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        trenoService = context.getBean(TrenoService.class);
        
       
    
        
        
        
//		trenoService.createTreno(treno1);
//		trenoService.createTreno(treno2);
//		trenoService.createTreno(treno3);
//		trenoService.createTreno(treno4);
//		trenoService.createTreno(treno5);
//		trenoService.createTreno(treno6);
		
		
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
	
	public static Utente findUtente(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean(UtenteDao.class); 
		Utente u = dao.find(id);
		System.out.println("Trovato Utente: " + u);
		return u;
	}
	
}
