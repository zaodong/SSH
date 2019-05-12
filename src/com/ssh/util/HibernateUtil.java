package com.ssh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		this.sessionFactory = sessionFactory;
	}
	
	//SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//Session
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}
	
	//Session
	public static void closeSession(Session session) {
		if(session != null) {
			session.close();
		}
	}
}
