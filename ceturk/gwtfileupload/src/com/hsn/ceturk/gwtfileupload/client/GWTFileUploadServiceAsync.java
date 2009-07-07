package com.hsn.ceturk.gwtfileupload.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GWTFileUploadService</code>.
 */
public interface GWTFileUploadServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback);
}
