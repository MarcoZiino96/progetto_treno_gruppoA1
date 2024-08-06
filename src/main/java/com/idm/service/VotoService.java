package com.idm.service;

import com.idm.entity.Voto;

public interface VotoService {
	public  Voto creaVoto( Voto voto);
	public  Voto findVoto(int id);
	public  Voto updateVoto(Voto voto, int id);
	public  void deleteVoto(int id);

}
