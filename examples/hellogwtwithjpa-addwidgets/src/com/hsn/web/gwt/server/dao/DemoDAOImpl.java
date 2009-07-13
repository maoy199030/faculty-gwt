package com.hsn.web.gwt.server.dao;

import javax.persistence.EntityManager;

public class DemoDAOImpl extends BaseDAOImpl implements DemoDAO {

	public DemoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
