package com.idm.test1;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.dao.UtenteDao;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.Utente;
import com.idm.entity.VagonePasseggeri;
public class TestService {



	public static void main(String[] args) {
		//findUtente(1);
		Utente utente1 = testCreaUtente("Lollo", "My", "lollomy@gmail.com", LocalDate.parse("1980-01-01"), "aaaaaaa", "lollomy98");
		Utente utente2 = testCreaUtente("Mario", "Leonardi", "mariuzzo@gmail.com", LocalDate.parse("1989-09-06"), "aaaaab", "marioleo89");
		Utente utente3 = testCreaUtente("Martina", "Consoli", "marti@gmail.com", LocalDate.parse("1989-09-06"), "aaaaab", "marti88");
		Utente utente4 = testCreaUtente("Marzia", "Groppo", "marzia@gmail.com", LocalDate.parse("1988-09-03"), "aaaaab", "marzia91");
		Utente utente5 = testCreaUtente("Alberto", "Bergesio", "albi@gmail.com", LocalDate.parse("1990-09-20"), "aaafab", "albi90");
		Utente utente6 = testCreaUtente("Roberto", "Piumatti", "robi@gmail.com", LocalDate.parse("1987-09-02"), "aavaab", "robi87");
		//		updateUtente( utente, 2);
		testFindUtenti();


	}


	public static Utente testCreaUtente(String name, String cognome, String email, LocalDate dataNascita, String password, String username) {


		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean(UtenteDao.class);

		Utente utente = new Utente();
		utente.setCognome(cognome);
		utente.setNome(name); 
		utente.setEmail(email);
		utente.setDataNascita(dataNascita); 
		utente.setPassword(password);
		utente.setUsername(username);

		utente = dao.create(utente);
		System.out.println("Creato Utente: " + utente);
		return utente;
	}


	public static Utente findUtente(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean(UtenteDao.class); 
		Utente u = dao.find(id);
		System.out.println("Trovato Utente: " + u);
		return u;
	}

	public static Utente updateUtente(Utente vp, int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean(UtenteDao.class);
		Utente utente = findUtente(id);
		utente.setCognome(utente.getCognome());
		utente.setDataNascita(utente.getDataNascita());
		utente.setEmail(utente.getEmail());
		utente.setNome(utente.getNome());
		utente.setUsername(utente.getUsername());
		utente.setPassword(utente.getPassword());

		utente = dao.update(utente);
		System.out.println("Aggiornato Utente: " + utente);
		return utente;
	}
	
	public static void testFindUtenti() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		UtenteDao dao = factory.getBean(UtenteDao.class); 	
		List<Utente> u = dao.retrive();
		System.out.println("Utenti trovati: " + u);
	}



}
