package com.hsn.web.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hsn.web.gwt.client.model.Personel;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("demo")
public interface DemoService extends RemoteService {
	String greetServer(String name);
	
	void createPersonel(Personel personel);
}
