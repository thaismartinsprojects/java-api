package co.thaismartins.utils;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

@SuppressWarnings("unchecked")
public abstract class BaseDAO<T, I> {
	
	private EntityManager entityManager;
	
	public BaseDAO() {
		SimpleEntityManagerFactory factory = new SimpleEntityManagerFactory();
		entityManager = factory.getEntityManager();
	}
	
	public T getById(I pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }
 
    public T save(T entity) {
    	
    	entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        
        return entity;
    }
 
    public T update(T entity) {
    	
    	entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();

        return entity;
    }
 
    public void delete(T entity) {
    	entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
 
	public List<T> getAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }
 
    private Class<T> getTypeClass() {
    	
        return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
    }
}
