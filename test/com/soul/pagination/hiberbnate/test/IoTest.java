package com.soul.pagination.hiberbnate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.soul.pagination.db.HibernateUtil;
import com.soul.pagination.db.audit.DbOpsListener;
import com.soul.pagination.db.entities.InsertionOrder;

public class IoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session =  sessionFactory.withOptions().interceptor(new DbOpsListener()).openSession();

		InsertionOrder i = (InsertionOrder)session.get(InsertionOrder.class, 2);
		
		System.out.println(i);
	}

}
