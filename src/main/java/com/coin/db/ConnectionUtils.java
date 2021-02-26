package com.coin.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
* Singleton to handle the hibernate session
*/
public class ConnectionUtils {
	private static final Logger log = LoggerFactory.getLogger(ConnectionUtils.class);

	private static SessionFactory sessionFactory;
	private ConnectionUtils() {}

	public static SessionFactory getSession() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static void closeSession() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
