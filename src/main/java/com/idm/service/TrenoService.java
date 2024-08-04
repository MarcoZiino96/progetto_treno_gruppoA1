package com.idm.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.idm.abstractClasses.AbstractVagone;
import com.idm.config.Beans;
import com.idm.dao.TrenoDao;
import com.idm.entity.FrecciaRossaBuilder;
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
    private TrenoFilterService trenoFilterService;

	
    
	public Treno find(Integer id) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        trenoDao = context.getBean(TrenoDao.class);
        
		Treno trenoFind = trenoDao.find(id);
		System.out.println(trenoFind);
		return trenoFind;
	}


	
	public Treno createTreno(String string) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        trenoDao = context.getBean(TrenoDao.class);
        AnnotationConfigApplicationContext contextBuilder = new AnnotationConfigApplicationContext(Beans.class);
        frecciaRossaBuilder = context.getBean(FrecciaRossaBuilder.class);
        
        Treno treno = frecciaRossaBuilder.creaTreno(string);
    
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
                .mapToDouble(AbstractVagone::getLunghezza) 
                .sum();
        treno.setSigla(string);
        treno.setPrezzo(prezzoTreno);
        treno.setLunghezza(lunghezzaTreno);
        treno.setPeso(pesoTreno);
        trenoDao.create(treno);
       return treno;
	}

	

	public Treno createTreno(Treno treno) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
//        trenoDao = context.getBean(TrenoDao.class);
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
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
//        trenoDao = context.getBean(TrenoDao.class);
		
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
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
//        trenoDao = context.getBean(TrenoDao.class);
		List<Treno> u = trenoDao.retrive();
		System.out.println(u);
		return u;
	}

	public List<Treno> retriveWithOrder(String ordine, String direction) {
//        BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
//        TrenoDao dao = factory.getBean("TrenoDao", TrenoDao.class);
        List<Treno> u = trenoDao.retriveWithOrder(ordine, direction);
        System.out.println(u);
		return u;
    }
	
    public List<Treno> findByFilter(TrenoFilter filter) {
        return trenoFilterService.filterTreni(filter);
    }
    
    public List<TrenoVO> getTreniVO() {
        List<Treno> treni = trenoDao.retrive(); 
        List<TrenoVO> trenoVOs = new ArrayList<>();
        for (Treno treno : treni) {
            TrenoVO vo = new TrenoVO();
            
            vo.setId(treno.getId());
            vo.setUtente(treno.getUtente());
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
	
}
