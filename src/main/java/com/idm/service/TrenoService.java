package com.idm.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.config.Beans;
import com.idm.dao.TrenoDao;
import com.idm.entity.Factory;
import com.idm.entity.FrecciaRossaBuilder;
import com.idm.entity.ItaloBuilder;
import com.idm.entity.TreNordBuilder;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.entity.Utente;
import com.idm.vo.TrenoVO;



@Component
public class TrenoService {

	@Autowired
	private TrenoDao trenoDao;
	@Autowired
	private FrecciaRossaBuilder frecciaRossaBuilder;
	@Autowired
	private ItaloBuilder italoBuilder;
	@Autowired
	private TreNordBuilder treNordBuilder;
    @Autowired     
    private TrenoFilterService trenoFilterService;

	
    
	public Treno find(Integer id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        trenoDao = context.getBean(TrenoDao.class);
        
		Treno trenoFind = trenoDao.find(id);
		System.out.println(trenoFind);
		return trenoFind;
	}

	
	public Treno createTreno(String string, Factory compagnia){

       Treno treno = selectFactory(string, compagnia);
    
        if(treno.getVagoni().isEmpty()) {
        	throw new RuntimeException("La lista è vuota");
        }
        
        double prezzoTreno = treno.getVagoni().stream()
                .mapToDouble(AbstractVagone::getPrezzo) 
                .sum();
        
        double lunghezzaTreno = treno.getVagoni().stream()
                .mapToDouble(AbstractVagone::getLunghezza) 
                .sum();
        
        double pesoTreno = treno.getVagoni().stream()
                .mapToDouble(AbstractVagone::getPeso) 
                .sum();
        
        treno.setSigla(string);
        treno.setPrezzo(prezzoTreno);
        treno.setLunghezza(lunghezzaTreno);
        treno.setPeso(pesoTreno);
        trenoDao.create(treno);
       return treno;
	}

	

	public Treno createTreno(Treno treno) {
		Treno treno1 = new Treno();
		treno1.setCompagnia(treno.getCompagnia());
		treno1.setSigla(treno.getSigla());
		treno1.setUtente(treno.getUtente());
		treno1.setFoto(treno.getFoto());
		treno1.setLunghezza(treno.getLunghezza());
		treno1.setPeso(treno.getPeso());
		treno1.setPrezzo(treno.getPrezzo());
		treno1 = trenoDao.create(treno1);
		
		return treno1;
	}

	public Treno update(Treno treno,int id) {

		
		Treno treno1 = find(id);
		treno1.setSigla(treno.getSigla());
		treno1.setCompagnia(treno.getCompagnia());
		treno1.setUtente(treno.getUtente());
		treno1.setFoto(treno.getFoto());
		treno1.setLunghezza(treno.getLunghezza());
		treno1.setPeso(treno.getPeso());
		treno1.setPrezzo(treno.getPrezzo());
		
		trenoDao.update(treno1);
		return treno1;
	}

	public void delete(Treno treno) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        trenoDao = context.getBean(TrenoDao.class);
		trenoDao.delete(treno);
	}

	public void delete(Integer id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        trenoDao = context.getBean(TrenoDao.class);
		trenoDao.delete(id);
	}

	public List<Treno> retrive() {
		List<Treno> u = trenoDao.retrive();
		System.out.println(u);
		return u;
	}

	public List<Treno> retriveWithOrder(String ordine, String direction) {
        List<Treno> u = trenoDao.retriveWithOrder(ordine, direction);
        System.out.println(u);
		return u;
    }
	
    public List<Treno> findByFilter(TrenoFilter filter) {
        return trenoFilterService.filterTreni(filter);
    }
    
    //--------CONVERSIONI VO----------//
    
    public List<TrenoVO> getTreniVO() {
        List<Treno> treni = trenoDao.retrive(); 
        List<TrenoVO> trenoVOs = new ArrayList<>();
        for (Treno treno : treni) {
            TrenoVO vo = new TrenoVO();
            
            vo.setId(treno.getId());
            vo.setUtenteUsername(treno.getUtente().getUsername());
            vo.setPrezzo(treno.getPrezzo());
            vo.setPeso(treno.getPeso());
            vo.setLunghezza(treno.getLunghezza());
            vo.setSigla(treno.getSigla());
            vo.setFoto(treno.getFoto());
            vo.setCompagnia(treno.getCompagnia());
            
            trenoVOs.add(vo);
        }
        return trenoVOs;
    }
    
    
    public List<TrenoVO> retriveWithOrderVO(String ordine, String direction) {
    	List<Treno> u = trenoDao.retriveWithOrder(ordine, direction);
    	List<TrenoVO> trenoVOs = new ArrayList<>();
    	for (Treno treno : u) {
    		TrenoVO vo = new TrenoVO();
            vo.setId(treno.getId());
            vo.setUtenteUsername(treno.getUtente().getUsername());
            vo.setPrezzo(treno.getPrezzo());
            vo.setPeso(treno.getPeso());
            vo.setLunghezza(treno.getLunghezza());
            vo.setSigla(treno.getSigla());
            vo.setFoto(treno.getFoto());
            vo.setCompagnia(treno.getCompagnia());
    	
            trenoVOs.add(vo);
    	}    	
    	return trenoVOs;
    }
    
    public Treno selectFactory(String sigla, Factory compagnia) {
        switch(compagnia) {
            case FR:
                return frecciaRossaBuilder.creaTreno(sigla);
            case IT:
                return italoBuilder.creaTreno(sigla);
            case TN:
                return treNordBuilder.creaTreno(sigla);
            default:
                throw new IllegalArgumentException("Compagnia non supportata: " + compagnia);
        }
    }
}
    	
 

