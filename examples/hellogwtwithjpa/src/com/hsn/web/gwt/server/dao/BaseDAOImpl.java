package com.hsn.web.gwt.server.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hsn.web.gwt.client.model.BaseDemoObject;

public abstract class BaseDAOImpl implements BaseDAO {

	private EntityManager entityManager;

	public BaseDAOImpl(EntityManager entityManager) {
		this.setEntityManager(entityManager);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void persist(BaseDemoObject nesne) {
		getEntityManager().persist(nesne);
	}

	public void update(BaseDemoObject nesne) {
		getEntityManager().merge(nesne);
	}

	public void refresh(BaseDemoObject nesne) {
		getEntityManager().refresh(nesne);
	}
	
	public void delete(BaseDemoObject nesne) {
		getEntityManager().remove(nesne);
	}

	public void delete(String nesneAdi, int id) {
		StringBuffer query = new StringBuffer("DELETE FROM ").append(nesneAdi).append(
				" n WHERE n.id = ").append(id);
		getEntityManager().createQuery(query.toString()).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<? extends BaseDemoObject> loadAll(String className) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Select t from ").append(className).append(" t");
		return getEntityManager().createQuery(stringBuilder.toString()).getResultList();
	}

	public void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	public void commitTransaction() {
		getEntityManager().getTransaction().commit();
	}
	
	public void rollbackTransaction() {
		getEntityManager().getTransaction().rollback();
	}

	@SuppressWarnings("unchecked")
	public <T extends BaseDemoObject> T executeNamedQueryForSingleResult(String queryName,
			Map<String, Object> parameters) {
		Query query = getEntityManager().createNamedQuery(queryName);
		for (Entry<String, Object> param : parameters.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
		return (T) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public <T extends BaseDemoObject> List<T> executeNamedQueryForResultList(String queryName,
			Map<String, Object> parameters) {
		Query query = getEntityManager().createNamedQuery(queryName);
		for (Entry<String, Object> param : parameters.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
		return query.getResultList();
	}

	public <T extends BaseDemoObject> T findById(Class<T> sinif, Integer id) {
//		Class<T> persistentClass = (Class<T>) ((ParameterizedType) getClass()
//                .getGenericSuperclass()).getActualTypeArguments()[0];
		return getEntityManager().find(sinif, id);
	}

}
