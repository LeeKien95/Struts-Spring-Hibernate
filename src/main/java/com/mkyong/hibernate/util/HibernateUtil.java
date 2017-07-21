package com.mkyong.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		 try {
	            // Create the SessionFactory from hibernate.cfg.xml
			 return new Configuration().configure().buildSessionFactory();
	     } catch(Throwable ex) {
	    	 System.err.println("Initial SessionFactory creation failed." + ex);
	         throw new ExceptionInInitializerError(ex);
	     }
	}
    
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}