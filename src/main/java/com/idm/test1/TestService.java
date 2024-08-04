package com.idm.test1;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.dao.UtenteDao;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.Utente;
import com.idm.entity.VagonePasseggeri;
import com.idm.service.TrenoService;
import com.idm.service.UtenteService;
public class TestService {
	
	//@Autowired
	private static UtenteService utenteService;



	public static void main(String[] args) {
		
		String nome = "Giovanni";
        String cognome = "Rossi";
        LocalDate dataNascita = LocalDate.of(1990, 5, 15); // Anno, Mese, Giorno
        String username = "giovanni90";
        String email = "giovanni.rossi@example.com";
        String password = "securePassword123";
		//findUtente(1);
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
          utenteService = context.getBean(UtenteService.class);
		 Utente nuovoUtente = new Utente(nome, cognome, dataNascita, username, email, password);
		
		 creaUtente(nuovoUtente);
		 System.out.println(nuovoUtente);


	}


	public static Utente creaUtente(Utente utente) {
		Utente utente1 = new Utente();
		utente1.setCognome(utente.getCognome());
		utente1.setNome(utente.getNome()); 
		utente1.setEmail(utente.getEmail());
		utente1.setDataNascita(utente.getDataNascita()); 
		utente1.setPassword(utente.getPassword());
		utente1.setUsername(utente.getUsername());

//		utenteService.createUtente(utente);
		System.out.println("Creato Utente: " + utente);
		return utente;
	}


	public static Utente findUtente(int id) {
		Utente utente = utenteService.find(id);
		System.out.println("Trovato Utente: " + utente);
		return utente;
	}

//	public static Utente updateUtente(Utente vp, int id) {
//		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
//		UtenteDao dao = factory.getBean(UtenteDao.class);
//		Utente utente = findUtente(id);
//		utente.setCognome(utente.getCognome());
//		utente.setDataNascita(utente.getDataNascita());
//		utente.setEmail(utente.getEmail());
//		utente.setNome(utente.getNome());
//		utente.setUsername(utente.getUsername());
//		utente.setPassword(utente.getPassword());
//
//		utente = dao.update(utente);
//		System.out.println("Aggiornato Utente: " + utente);
//		return utente;
//	}
//	
//	public static void testFindUtenti() {
//		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
//		UtenteDao dao = factory.getBean(UtenteDao.class); 	
//		List<Utente> u = dao.retrive();
//		System.out.println("Utenti trovati: " + u);
//	}



}
