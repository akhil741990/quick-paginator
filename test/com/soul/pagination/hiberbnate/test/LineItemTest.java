package com.soul.pagination.hiberbnate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.soul.pagination.db.HibernateUtil;
import com.soul.pagination.db.audit.DbOpsListener;
import com.soul.pagination.db.entities.LineItem;

public class LineItemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session =  sessionFactory.withOptions().interceptor(new DbOpsListener()).openSession();

		LineItem i = (LineItem)session.get(LineItem.class, 2);
		
		System.out.println(i);
	}

}
