package com.soul.pagination.hiberbnate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.soul.pagination.db.HibernateUtil;
import com.soul.pagination.db.audit.DbOpsListener;
import com.soul.pagination.db.entities.Advertiser;
import com.soul.pagination.db.entities.InsertionOrder;

public class AvertiserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session =  sessionFactory.withOptions().interceptor(new DbOpsListener()).openSession();

		Advertiser i = (Advertiser)session.get(Advertiser.class, 13428);
		
		System.out.println(i);
	}

}
