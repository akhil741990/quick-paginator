package com.soul.pagination.db.audit;

import java.io.Serializable;


import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.soul.pagination.db.entities.Student;

public class DbOpsListener extends EmptyInterceptor{
	
	
	@Override
	public boolean onSave(Object entity, Serializable id, 
	  Object[] state, String[] propertyNames, Type[] types) {
	     
	    if (entity instanceof Student) {
	        System.out.println((((Student) entity).toString()));
	    }
	    return super.onSave(entity, id, state, propertyNames, types);

	}    
}
