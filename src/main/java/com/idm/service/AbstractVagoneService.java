package com.idm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.config.Beans;
import com.idm.dao.AbstractVagoneDao;
import com.idm.dao.VagoneRistoranteDao;
import com.idm.entity.VagoneRistorante;

public class AbstractVagoneService {
	
	@Autowired
	private AbstractVagoneDao abtsractVagoneDao;

	public AbstractVagone create(VagoneRistorante vagoneRistorante) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
		abtsractVagoneDao = context.getBean(AbstractVagoneDao.class);
        
		AbstractVagone va = abtsractVagoneDao.add(vagoneRistorante);
		return va;
	}
	
	
}
