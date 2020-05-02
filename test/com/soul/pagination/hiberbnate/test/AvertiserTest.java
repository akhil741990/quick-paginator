package com.soul.pagination.hiberbnate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soul.pagination.db.HibernateUtil;
import com.soul.pagination.db.audit.DbOpsListener;
import com.soul.pagination.db.entities.Advertiser;

public class AvertiserTest {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session =  sessionFactory.withOptions().interceptor(new DbOpsListener()).openSession();

		Advertiser i = (Advertiser)session.get(Advertiser.class, 13428);
		
		ObjectMapper mapper = new ObjectMapper();
		
		 String jsonString = mapper.writeValueAsString(i);
	      System.out.println(jsonString);
	      
	      
	      
	}

}
