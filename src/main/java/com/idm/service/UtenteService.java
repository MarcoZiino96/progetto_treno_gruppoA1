package com.idm.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.idm.config.Beans;
import com.idm.dao.TrenoDao;
import com.idm.dao.UtenteDao;
import com.idm.entity.Treno;
import com.idm.entity.Utente;

@Component
public class UtenteService {

	@Autowired
	private UtenteDao utenteDao;


	public Utente find(Integer id) {
		Utente utenteFind = utenteDao.find(id);
		System.out.println(utenteFind);
		return utenteFind;
	}


	public Utente createUtente(Utente utente) {
		Utente utenteNew = new Utente();
		utenteNew.setCognome(utente.getCognome());
		utenteNew.setNome(utente.getNome()); 
		utenteNew.setEmail(utente.getEmail());
		utenteNew.setDataNascita(utente.getDataNascita()); 
		utenteNew.setPassword(utente.getPassword());
		utenteNew.setUsername(utente.getUsername());

		utente = utenteDao.create(utente);
		return utente;
	}


	public Utente update(Utente ref,int id) {
		Utente utente = find(id);
		
		utente.setCognome(ref.getCognome());
		utente.setDataNascita(ref.getDataNascita());
		utente.setEmail(ref.getEmail());
		utente.setNome(ref.getNome());
		utente.setUsername(ref.getUsername());
		utente.setPassword(ref.getPassword());
		
		utenteDao.update(utente);
		
		return utente;
	}


	public void delete(Utente ref) {
		utenteDao.delete(ref);

	}


	public void delete(int id) {
		utenteDao.delete(id);

	}
	
	public List<Utente> retrive(){
		List<Utente> u = utenteDao.retrive();
		System.out.println(u);
		return u;
	}



}
