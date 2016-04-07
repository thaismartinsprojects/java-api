package co.thaismartins.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public final class SimpleEntityManagerFactory {
	
	private final String PERSISTENCE_UNIT_NAME = "thaismartins";
	
	private EntityManager entityManager;

	private EntityManagerFactory factory;
	
	public EntityManager getEntityManager() {
		
		if(this.entityManager == null)
			this.entityManager = getFactoryInstance().createEntityManager();
		
		return this.entityManager;
	}
	
	public void begin() {
		getTransaction().begin();
	}
	
	public void commit() {
		getTransaction().commit();
	}
	
	public void rollback() {
		getTransaction().rollback();
	}
	
	public void close() {
		getEntityManager().close();
		this.factory.close();
	}

	public EntityTransaction getTransaction() {
		return getEntityManager().getTransaction();
	}
	
	private EntityManagerFactory getFactoryInstance() {
		
		if(this.factory == null)
			this.factory =  Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		return this.factory;
	}
}
