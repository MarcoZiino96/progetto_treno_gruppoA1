package com.idm.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.idm.config.Beans;
import com.idm.dao.AbstractVagoneDao;
import com.idm.entity.Treno;
import com.idm.service.TrenoService;


public class TrenoserviceTest {

	//@Autowired
	private static TrenoService  trenoService;
	

	
	public static void main(String[] args) {
		
	  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
      TrenoService  trenoService = context.getBean(TrenoService.class);
		
//      Treno treno = trenoService.find(1);
//      
//      System.out.println(treno.getVagoni());
      
       
       trenoService.createTreno("hppp");
	}
	
	public static void creaTreno(String string) {
		trenoService.createTreno(string);
	}
	
	public static void findTreno(int id) {
		trenoService.find(id);
	}
	
	
	

//	public static void testCreaAggiornaEliminaTreno() {
//
//		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
//		TrenoDao trenoDao = factory.getBean("TrenoDao", TrenoDao.class);
//
//
//		Utente utente = testCreaUtente("Mario", "Rossi", "mario.rossi@gmail.com", LocalDate.parse("1980-01-01"), "password", "marioRossi");
//
//
//		Treno treno = new Treno(utente, "TR789");
//		treno = trenoDao.create(treno);
//		System.out.println("Treno creato per eliminazione: " + treno);
//
//		treno.setSigla("TR999");
//		treno = trenoDao.update(treno);
//		System.out.println("Treno aggiornato: " + treno);
//
//
//		trenoDao.delete(treno.getId());
//		System.out.println("Treno eliminato con id: " + treno.getId());
//
//
//		Treno deletedTreno = trenoDao.find(treno.getId());
//		System.out.println("Treno dopo l'eliminazione: " + deletedTreno);
//
//	}
//
//	public static Utente testCreaUtente(String name, String cognome, String email, LocalDate dataNascita, String password, String username) {
//
//		System.out.println("-".repeat(30));
//		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
//		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class);
//
//		Utente utente = new Utente();
//		utente.setCognome(cognome);
//		utente.setNome(name); 
//		utente.setEmail(email);
//		utente.setDataNascita(dataNascita); 
//		utente.setPassword(password);
//		utente.setUsername(username);
//
//		utente = dao.create(utente);
//		System.out.println(utente);
//		return utente;
//	}
//
//	public static void testFindUtenteDao() {
//
//		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
//		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class); 
//		Utente u = dao.find(1);
//		System.out.println(u);
//
//	}   	
//	public static void testFindUtenti() {
//		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
//		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class); 	
//		List<Utente> u = dao.retrive();
//		System.out.println(u);
//
//	}
//
//	public static void testEliminaUtente() {
//		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
//		UtenteDao dao = factory.getBean("UtenteDao", UtenteDao.class); 
//
//
//		Utente createdUtente = testCreaUtente( "Franco", "Giallo", "francogiallo@gmail.com", LocalDate.parse("2000-07-07"), "qqqqqqq", "francoGiallo");
//		System.out.println("Utente creato: " + createdUtente);
//
//
//		createdUtente.setEmail("franco.updated@gmail.com");
//		Utente updatedUtente = dao.update(createdUtente);
//		Utente updatedUtente2 = dao.update(createdUtente);
//		
//		System.out.println("Utente aggiornato: " + updatedUtente);
//
//
//		dao.delete(createdUtente.getId());
//		System.out.println("Utente eliminato: " + createdUtente.getId());
//
//
//		Utente deletedUtente = dao.find(createdUtente.getId());
//		System.out.println("Utente dopo l'eliminazione: " + deletedUtente);
//	}
//
//	public static void testCreaAggiornaEliminaLocomotiva() {
//		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
//		LocomotivaDao locomotivaDao = factory.getBean("LocomotivaDao", LocomotivaDao.class);
//
//
//		Locomotiva locomotiva = new Locomotiva();
//		locomotiva.setPotenza("5000 HP");
//		locomotiva.setLunghezza(20.5f);
//		locomotiva.setPeso(12000.0f);
//		locomotiva.setPrezzo(150000.0);
//		locomotiva = locomotivaDao.create(locomotiva);
//		System.out.println("Locomotiva creata: " + locomotiva);
//
//
//		locomotiva.setPotenza("6000 HP");
//		locomotiva.setLunghezza(21.0f);
//		locomotiva.setPeso(12500.0f);
//		locomotiva.setPrezzo(160000.0);
//		locomotiva = locomotivaDao.update(locomotiva);
//		System.out.println("Locomotiva aggiornata: " + locomotiva);
//
//
//		Locomotiva updatedLocomotiva = locomotivaDao.find(locomotiva.getId());
//		System.out.println("Locomotiva dopo aggiornamento: " + updatedLocomotiva);
//
//
//		locomotivaDao.delete(locomotiva.getId());
//		System.out.println("Locomotiva eliminata: " + locomotiva.getId());
//
//
//		Locomotiva deletedLocomotiva = locomotivaDao.find(locomotiva.getId());
//		System.out.println("Locomotiva dopo eliminazione: " + deletedLocomotiva);
//	}
//


}
