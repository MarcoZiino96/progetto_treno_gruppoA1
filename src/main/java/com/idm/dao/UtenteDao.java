package com.idm.dao;

import java.util.List;

import org.springframework.stereotype.Component;


import com.idm.entity.Utente;


@Component
public interface UtenteDao {
	public Utente find(Integer id);
	public Utente create(Utente ref);
	public Utente update(Utente ref);
	public void delete(Utente ref);
	public void delete(int id);
	public List<Utente> retrive();
	public List<Utente> searchByUsername(String username);
	
}
