package com.denizturkmen.Client;



import java.util.Date;

import org.hibernate.Session;

import com.denizturkmen.Entity.Partner;
import com.denizturkmen.Entity.Person;
import com.denizturkmen.Entity.Phone;
import com.denizturkmen.Entity.PhoneType;
import com.denizturkmen.Util.HibernateUtil;

public class SaveClient {
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			
			Person person1 = new Person();
			person1.setName("Deniz Türkmen");
			person1.setNickName("denizm");
			person1.setAddress("Ankara");
			person1.setCreatedOn(new Date());
			person1.setVersion(1);
			
			Phone phone1 = new Phone();
			phone1.setNumber("90532456455");
			phone1.setType(PhoneType.MOBILE);
			phone1.setPerson(person1);
			
			person1.getPhones().add(phone1);
			
			Person person2 = new Person();
			person2.setName("Eren Türkmen");
			person2.setNickName("enen");
			person2.setAddress("ÇorumStreet");
			person2.setCreatedOn(new Date());
			person2.setVersion(1);
			
			Phone phone2 = new Phone();
			phone2.setNumber("90434351344");
			phone2.setType(PhoneType.MOBILE);
			phone2.setPerson(person2);
			
			Phone phone3 = new Phone();
			phone3.setNumber("90135554455");
			phone3.setType(PhoneType.LAND_LINE);
			phone3.setPerson(person2);
			
			person2.getPhones().add(phone2);
			person2.getPhones().add(phone3);
			
			Partner partner = new Partner();
			partner.setName("Besra");
			partner.setVersion(1);
			
			session.save(person1);
			session.save(person2);
			session.save(partner);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


