package com.hsn.ceturk.hellogwtwithjpa.server.dao;

import javax.persistence.EntityManager;

public class DemoDAOImpl extends BaseDAOImpl implements DemoDAO {

	public DemoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
