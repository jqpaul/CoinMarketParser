package com.coin.writer;

import java.util.List;

import com.coin.data.json.Coin;
import com.coin.data.json.Statistic;
import com.coin.db.ConnectionUtils;

import org.hibernate.Session;

/**
* Postgres-specific implementation of the {@link IWriter} interface
*/
public class PostgresWriter implements IWriter<Statistic> {

	/**
	* Writes object to database
	*/
	@Override
	public void write(List<Statistic> t) {
		Session session = ConnectionUtils.getSession().openSession();
		session.beginTransaction();

		// Commiting can't be done in parallel so 
		// has to be done decoupled from the parallelStream
		t.stream()
			 .forEach((stat) -> commit(stat, session));
		
		session.getTransaction().commit();
		session.close();
		ConnectionUtils.closeSession();
	}

	/**
	* Using ConnectionUtils.java to commit a single Statistic object
	*
	* @param stat 
	* @param session
	 */
	private void commit(Statistic stat, Session session) {
		for (Coin c: stat.getData()) {
			session.save(c.getQuote().getUSD());
			session.save(c.getQuote());
			if (c.getPlatform() != null)
				session.save(c.getPlatform());
			session.save(c);
		}
		session.save(stat);
	}
}
