package com.idm.test1;



import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.dao.VagoneCargoDao;
import com.idm.entity.VagoneCargo;

public class TestVagoneCargo {

	public static void main(String[] args) {
		
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagoneCargoDao dao = factory.getBean("VagoneCargoDao",VagoneCargoDao.class);
		
		
//		addVagoneCargo(3005,4, 1.7, 7000);
//		addVagoneCargo(2000,4, 1.3, 7000);
//		VagoneCargo vcDaModificare = findVagoneCargo(1);
//		vcDaModificare.setLunghezza(1800); 
//		updateVagoneCargo(vcDaModificare);
//		deleteVagoneCargo(8);
//		dao.delete(8);
	}
	
	
	public static VagoneCargo addVagoneCargo(float lunghezza, float peso, double prezzo, double capacita) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagoneCargoDao dao = factory.getBean("VagoneCargoDao",VagoneCargoDao.class);
		
		VagoneCargo vagoneCargo = new VagoneCargo();
		
		vagoneCargo.setLunghezza(lunghezza);
		vagoneCargo.setPeso(peso);
		vagoneCargo.setPrezzo(prezzo);
		vagoneCargo.setCapacitaMassima(capacita);
		
		VagoneCargo vc = dao.add(vagoneCargo);
		return vc;
	}
	
	
	public static VagoneCargo findVagoneCargo(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagoneCargoDao dao = factory.getBean("VagoneCargoDao",VagoneCargoDao.class);
		System.out.println(dao.find(id));
		return dao.find(id);
	}
	
	public static VagoneCargo updateVagoneCargo(VagoneCargo vagoneCargo, int id) {
	BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
	VagoneCargoDao dao = factory.getBean("VagoneCargoDao",VagoneCargoDao.class);
	
	VagoneCargo OldVagoneCargo = findVagoneCargo(id);

	OldVagoneCargo.setLunghezza(vagoneCargo.getLunghezza());
	OldVagoneCargo.setPeso(vagoneCargo.getPeso());
	OldVagoneCargo.setPrezzo(vagoneCargo.getPrezzo());
	OldVagoneCargo.setCapacitaMassima(vagoneCargo.getCapacitaMassima());
	  
	  dao.update(OldVagoneCargo);
	  return(OldVagoneCargo);
}
	
	
	public static void deleteVagoneCargo(int id){
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagoneCargoDao dao = factory.getBean("VagoneCargoDao",VagoneCargoDao.class);
		 dao.delete(id);
	}
	
}
