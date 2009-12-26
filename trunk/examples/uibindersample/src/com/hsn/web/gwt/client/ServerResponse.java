package com.hsn.web.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ServerResponse extends Composite {

	private static ServerResponseUiBinder uiBinder = GWT.create(ServerResponseUiBinder.class);

	interface ServerResponseUiBinder extends UiBinder<Widget, ServerResponse> { }

	@UiField
	DivElement msgBox;
	
	public @UiConstructor ServerResponse() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String message) {
		msgBox.setInnerText(message);
	}
}
