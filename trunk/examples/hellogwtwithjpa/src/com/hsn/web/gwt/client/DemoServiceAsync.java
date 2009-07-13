package com.hsn.web.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>DemoService</code>.
 */
public interface DemoServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback);
}
