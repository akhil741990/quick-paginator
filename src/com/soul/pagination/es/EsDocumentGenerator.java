package com.soul.pagination.es;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soul.pagination.db.HibernateUtil;
import com.soul.pagination.db.audit.DbOpsListener;
import com.soul.pagination.db.entities.Advertiser;

public class EsDocumentGenerator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session =  sessionFactory.withOptions().interceptor(new DbOpsListener()).openSession();


		List<Advertiser> list = session.createQuery("from advertiser").list();
		
		
		BufferedWriter writer = new BufferedWriter(
                new FileWriter("json.txt", true)  //Set true for append mode
            ); 
		for(Advertiser i : list){
			ObjectMapper mapper = new ObjectMapper();
			
			 String jsonString = mapper.writeValueAsString(i);
			 int id = i.getId();
			 String output = String.format("{\"index\":{\"_id\":\"%d\"}}", id);
			writer.newLine();   //Add new line
			writer.write(output);
			writer.newLine();   //Add new line
			writer.write(jsonString);
		}
		writer.close();
		 
		 
		 

	}

}
