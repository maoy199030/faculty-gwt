package com.hsn.web.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MessageBox extends DialogBox {

	private static MessageBoxUiBinder uiBinder = GWT.create(MessageBoxUiBinder.class);

	interface MessageBoxUiBinder extends UiBinder<VerticalPanel, MessageBox> { }
	
	@UiField
	Button closeButton;

	@UiField
	Label textToServerLabel;
	
	@UiField
	ServerResponse serverResponseLabel;
	
	public MessageBox() {
		setText("Remote Procedure Call");
		setAnimationEnabled(true);
		
		setWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("closeButton")
	public void onCloseClick(ClickEvent e) {
		hide();
	}
}
