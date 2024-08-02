package com.idm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.idm.config.Beans;
import com.idm.dao.VotoDao;
import com.idm.entity.Voto;

@Component
public class VotoService {
	
	@Autowired
	VotoDao votoDao;

public  Voto creaVoto( Voto voto) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
    votoDao = context.getBean(VotoDao.class);		
      Voto v = new Voto();
		v.setTreno(voto.getTreno());
		v.setUtente(voto.getUtente());
		v.setVoto(voto.getVoto());
		votoDao.add(v);

		return v;

	}

	public  Voto findVoto(int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
	    votoDao = context.getBean(VotoDao.class);	
		Voto p = votoDao.find(id);
	
		return p;
	}
	
	public  Voto updateVoto(Voto voto, int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
	    votoDao = context.getBean(VotoDao.class);	
		Voto vOld = findVoto(id);
		vOld.setTreno(voto.getTreno());
		vOld.setUtente(voto.getUtente());
		vOld.setVoto(voto.getVoto());
		votoDao.update(vOld);
		return vOld;
	}
	
	public  void deleteVoto(int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
	    votoDao = context.getBean(VotoDao.class);	
		votoDao.delete(id);	
	}
}
