package com.hsn.web.gwt.server.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hsn.web.gwt.client.DemoService;
import com.hsn.web.gwt.client.model.Personel;
import com.hsn.web.gwt.server.dao.DemoDAO;
import com.hsn.web.gwt.server.dao.DemoDAOImpl;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class DemoServiceImpl extends RemoteServiceServlet implements DemoService {

	private DemoDAO demoDAO;
	
	public DemoServiceImpl() {
		super();
		
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo-app");
			demoDAO = new DemoDAOImpl(factory.createEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String greetServer(String input) {
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	@Override
	public void createPersonel(Personel personel) {
		// save object in db
		try {
			demoDAO.beginTransaction();
			demoDAO.persist(personel);
			demoDAO.commitTransaction();
		} catch (Exception p) {
			p.printStackTrace();
			demoDAO.rollbackTransaction();
			throw new RuntimeException("Personel kaydedilirken hata olustu : " + p.toString(), p);
		}
	}
}
