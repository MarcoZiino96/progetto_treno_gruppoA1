package com.idm.test1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.idm.config.Beans;
import com.idm.dao.VagonePasseggeriDao;
import com.idm.entity.VagonePasseggeri;

public class Test2 {

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
}
