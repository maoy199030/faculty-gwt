package com.hsn.web.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;

public class UIBinderDemo implements EntryPoint {

	interface Binder extends UiBinder<HTMLPanel, UIBinderDemo> { }

	private static Binder uiBinder = GWT.create(Binder.class);

	@UiField
	TextBox nameField;
	
	@UiField
	Button sendButton;

	@Override
	public void onModuleLoad() {
		// Create the UI defined in UIBinderDemo.ui.xml.
		final HTMLPanel mainPanel = uiBinder.createAndBindUi(this);
		
		// Focus the cursor on the name field when the app loads
		nameField.selectAll();
		
		// Add the outer panel to the RootLayoutPanel, so that it will be displayed.
		final RootLayoutPanel root = RootLayoutPanel.get();
		root.add(mainPanel);
	}
	
	@UiHandler("sendButton")
	public void onSendClick(ClickEvent e) {
		MessageBox message = new MessageBox();
		message.textToServerLabel.setText("text to server test");
		message.serverResponseLabel.setText("response label test");
		
		message.center();
		message.show();
	}
}
