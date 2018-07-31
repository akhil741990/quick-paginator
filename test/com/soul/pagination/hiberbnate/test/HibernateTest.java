package com.soul.pagination.hiberbnate.test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.soul.pagination.db.HibernateUtil;
import com.soul.pagination.db.audit.DbOpsListener;
import com.soul.pagination.db.entities.Student;

public class HibernateTest {

	public static void main(String args[]) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session =  sessionFactory.withOptions().interceptor(new DbOpsListener()).openSession();
        
        session.beginTransaction();
         
        
        Student student = new Student();
        student.setFirstName("Tom");
        student.setAge(16);
//        AuditLog log = new AuditLog();
//        log.setAction("Test_Action");
//        log.setCreatedDate(new Date(System.currentTimeMillis()));
//        log.setDetail("TestDetail");
//        log.setEntityId(1);
//        log.setEntityName("ENTITY_NAME");
        session.save(student);
        session.getTransaction().commit();
         
        session.close();
	}
}
