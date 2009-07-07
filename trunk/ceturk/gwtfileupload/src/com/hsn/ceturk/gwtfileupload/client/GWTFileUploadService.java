package com.hsn.ceturk.gwtfileupload.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("upload")
public interface GWTFileUploadService extends RemoteService {
	String greetServer(String name);
}
