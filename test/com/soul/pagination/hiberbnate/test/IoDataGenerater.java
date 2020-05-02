package com.soul.pagination.hiberbnate.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

import com.soul.pagination.db.HibernateUtil;
import com.soul.pagination.db.audit.DbOpsListener;
import com.soul.pagination.db.entities.Advertiser;

public class IoDataGenerater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session =  sessionFactory.withOptions().interceptor(new DbOpsListener()).openSession();

		
		List<Advertiser> list = session.createQuery("from advertiser").list();
		
		final HashSet<Integer> ids = new HashSet<Integer>();
		for(Advertiser adv : list){
			ids.add(adv.getId());
		}
		
		Transaction tx = session.beginTransaction();
		
		
		String query = "insert into insertion_order(name,advertiser_id) values (?,?)";
		
		session.doWork(new Work() {
			
			public void execute(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement stm = null;
				try {
					String query = "insert into insertion_order(name,advertiser_id) values (?,?)";
					stm  = conn.prepareStatement(query);
					int min = 10002;
					int max = 20001;
					for(int j =1;j<=50000;j++){				
						int i =  (int) ((Math.random() * (max - min)) + min);
						if(ids.contains(i)){
							stm.setString(1,"IO_"+j);
							stm.setInt(2, i);
							stm.addBatch();
						}
						//System.out.println("Adv Id :" + i);
						
						
						if(j%100 == 0){
							try{
								stm.executeBatch();
								System.out.println("Records saved = "+j);
							}catch (Exception e) {
								System.out.println(e.getMessage());
							}
							
						}
					}
					stm.executeBatch();
				}catch (Exception e) {
					// TODO: handle exception
				}finally {
					stm.close();
				}
				
			}
		});
		tx.commit();
		session.close();
		
	}

}
