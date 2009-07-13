package com.hsn.web.gwt.server.dao;

import java.util.List;
import java.util.Map;

import com.hsn.web.gwt.client.model.BaseDemoObject;

public interface BaseDAO {
	public void persist(BaseDemoObject nesne);

	public void update(BaseDemoObject nesne);
	
	public void refresh(BaseDemoObject nesne);

	public void delete(BaseDemoObject nesne);

	public void delete(String nesneAdi, int id);

	List<? extends BaseDemoObject> loadAll(String className);

	public void beginTransaction();

	public void commitTransaction();
	
	public void rollbackTransaction();

	<T extends BaseDemoObject> T executeNamedQueryForSingleResult(String queryName,
			Map<String, Object> parameters);

	<T extends BaseDemoObject> List<T> executeNamedQueryForResultList(String queryName,
			Map<String, Object> parameters);
	
	<T extends BaseDemoObject> T findById(Class<T> sinif, Integer id);

}
