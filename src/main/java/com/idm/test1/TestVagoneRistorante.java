package com.idm.test1;


import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.dao.VagoneCargoDao;
import com.idm.dao.VagoneRistoranteDao;
import com.idm.entity.VagoneCargo;
import com.idm.entity.VagoneRistorante;

public class TestVagoneRistorante {

	public static void main(String[] args) {
		
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagoneRistoranteDao dao = factory.getBean("VagoneRistoranteDao",VagoneRistoranteDao.class);
		
		
//		VagoneRistorante vagoneRistorante = new VagoneRistorante();
//		updateVagoneRistorante(vagoneRistorante,1);
		
		addVagoneRistorante(4000,7, 2.6, 6);
		addVagoneRistorante(3000,4, 2.2, 5);

//		dao.delete(4);
//		dao.delete(5);
	}

	
	public static VagoneRistorante addVagoneRistorante (float lunghezza, float peso, double prezzo, int numeroTavoli) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagoneRistoranteDao dao = factory.getBean("VagoneRistoranteDao",VagoneRistoranteDao.class);
		
		VagoneRistorante  vagoneRistorante  = new VagoneRistorante ();
		
		vagoneRistorante.setLunghezza(lunghezza);
		vagoneRistorante.setPeso(peso);
		vagoneRistorante.setPrezzo(prezzo);
		vagoneRistorante.setNumeroTavoli(numeroTavoli);
		VagoneRistorante vc = dao.add(vagoneRistorante);
		return vc;
	}
	
	public static VagoneRistorante findVagoneRistorante(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagoneRistoranteDao dao = factory.getBean("VagoneRistoranteDao",VagoneRistoranteDao.class);
		System.out.println(dao.find(id));
		return dao.find(id);
	}
	
	public static VagoneRistorante updateVagoneRistorante(VagoneRistorante vagoneRistorante, int id) {
	BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
	VagoneRistoranteDao dao = factory.getBean("VagoneRistoranteoDao",VagoneRistoranteDao.class);
	
	VagoneRistorante OldVagoneRistorante = findVagoneRistorante(id);

	OldVagoneRistorante.setLunghezza(vagoneRistorante.getLunghezza());
	OldVagoneRistorante.setPeso(vagoneRistorante.getPeso());
	OldVagoneRistorante.setPrezzo(vagoneRistorante.getPrezzo());
	OldVagoneRistorante.setNumeroTavoli(vagoneRistorante.getNumeroTavoli());
	  
	  dao.update(OldVagoneRistorante);
	  return(OldVagoneRistorante);
}
	
	public static void deleteVagoneRistorante(int id){
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagoneRistoranteDao dao = factory.getBean("VagoneRistoranteDao",VagoneRistoranteDao.class);
		 dao.delete(id);
	}
	
}
