package com.hsn.ceturk.hellogwtwithjpa.server.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hsn.ceturk.hellogwtwithjpa.client.DemoService;
import com.hsn.ceturk.hellogwtwithjpa.server.dao.DemoDAO;
import com.hsn.ceturk.hellogwtwithjpa.server.dao.DemoDAOImpl;

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
}
