package com.idm.test1;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.idm.config.Beans;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.VagonePasseggeri;

public class TestVagoni1 {

	  VagonePasseggeri creaVagonePasseggeri( float lunghezza,float peso,double prezzo, int numeroPosti) {
		
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		VagonePasseggeri vp = new VagonePasseggeri();
		vp.setNumeroPosti(numeroPosti);
		vp.setPrezzo(prezzo);
		vp.setLunghezza(lunghezza);
		vp.setPeso(peso);
		dao.add(vp);

		return vp;

	}

	public  VagonePasseggeri findVagonePasseggeri(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		VagonePasseggeri vp = dao.find(id);
		System.out.println(vp);
		return vp;
	}
	
	public  VagonePasseggeri updateVagonePasseggeri(VagonePasseggeri vp, int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		
		VagonePasseggeri vpOld = findVagonePasseggeri(id);
		
		vpOld.setLunghezza(vp.getLunghezza());
		vpOld.setNumeroPosti(vp.getNumeroPosti());
		vpOld.setPeso(vp.getPeso());
		vpOld.setPrezzo(vp.getPrezzo());
		dao.update(vpOld);
		return vpOld;
	}
	
	public  void deleteVagonePasseggeri(int id) {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		VagonePasseggeriDao dao = factory.getBean("vagonePasseggeri", VagonePasseggeriDao.class);
		dao.delete(id);	
	}
    
}
