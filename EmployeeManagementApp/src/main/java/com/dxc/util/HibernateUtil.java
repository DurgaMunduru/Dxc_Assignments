package com.dxc.util;

import java.text.Annotation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static {
		
		try {
			
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
		}catch(Exception e) {
			System.err.println("Session factory could not be created"+e);
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
