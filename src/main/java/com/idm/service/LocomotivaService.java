package com.idm.service;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.idm.config.Beans;
import com.idm.dao.LocomotivaDao;
import com.idm.dao.TrenoDao;
import com.idm.entity.Locomotiva;

@Component
public class LocomotivaService {

	@Autowired
	private LocomotivaDao locomotivaDao;




	public Locomotiva find(Integer id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        locomotivaDao = context.getBean(LocomotivaDao.class);
		Locomotiva locomotivaFind = locomotivaDao.find(id);
		return locomotivaFind;
	}

	public Locomotiva createLocomotiva(Locomotiva locomotiva) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        locomotivaDao = context.getBean(LocomotivaDao.class);

		Locomotiva locomotiva1 = new Locomotiva();
		locomotiva1.setPotenza(locomotiva.getPotenza());
		locomotiva1.setLunghezza(locomotiva.getLunghezza());
		locomotiva1.setPeso(locomotiva.getLunghezza());
		locomotiva1.setPrezzo(locomotiva.getPrezzo());

		locomotiva1 = locomotivaDao.create(locomotiva1);
		return locomotiva1;
	}

	public Locomotiva update(Locomotiva locomotiva,int id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        locomotivaDao = context.getBean(LocomotivaDao.class);

		Locomotiva locUpdate = find(id);

		locUpdate.setLunghezza(locUpdate.getLunghezza());
		locUpdate.setPeso(locUpdate.getPeso());
		locUpdate.setPotenza(locUpdate.getPotenza());
		locUpdate.setPrezzo(locUpdate.getPrezzo());
		locomotivaDao.update(locUpdate);
		return locUpdate;
	}

	public void delete(Locomotiva locomotiva) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        locomotivaDao = context.getBean(LocomotivaDao.class);
		locomotivaDao.delete(locomotiva);
	}

	public void delete(Integer id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        locomotivaDao = context.getBean(LocomotivaDao.class);
		locomotivaDao.delete(id);
	}

	public List<Locomotiva> retrive() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        locomotivaDao = context.getBean(LocomotivaDao.class);
		List<Locomotiva> u = locomotivaDao.retrive();
		return u;

	}

}
