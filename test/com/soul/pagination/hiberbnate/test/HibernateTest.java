package com.soul.pagination.hiberbnate.test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.soul.pagination.db.HibernateUtil;
import com.soul.pagination.db.entities.AuditLog;

public class HibernateTest {

	public static void main(String args[]) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         
        
        AuditLog log = new AuditLog();
        log.setAction("Test_Action");
        log.setCreatedDate(new Date(System.currentTimeMillis()));
        log.setDetail("TestDetail");
        log.setEntityId(1);
        log.setEntityName("ENTITY_NAME");
        session.save(log);
        session.getTransaction().commit();
         
        session.close();
	}
}
