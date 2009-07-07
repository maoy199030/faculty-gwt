package com.hsn.ceturk.gwtfileupload.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hsn.ceturk.gwtfileupload.client.GWTFileUploadService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GWTFileUploadServiceImpl extends RemoteServiceServlet implements GWTFileUploadService {

	public String greetServer(String input) {
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}
}
