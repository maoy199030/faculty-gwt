package com.hsn.web.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hsn.web.gwt.client.model.Personel;

/**
 * The async counterpart of <code>DemoService</code>.
 */
public interface DemoServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback);
	
	void createPersonel(Personel personel, AsyncCallback<Void> callback);
}
