package com.hsn.web.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.hsn.web.gwt.client.model.Personel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Hellogwtwithjpa implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final DemoServiceAsync demoService = GWT.create(DemoService.class);

	private PersonelGirisFormu form;

	private FlexTable table;

	private DecoratedTabPanel tabPanel;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		tabPanel = new DecoratedTabPanel();
		tabPanel.setWidth("400px");
		tabPanel.setAnimationEnabled(true);
		tabPanel.add(createPersonelGirisTabContent(), "Yeni Personel");
		tabPanel.add(createPersonelListesiTabContent(), "Personel Listesi");
		tabPanel.selectTab(1);
		
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("myFieldContainer").add(tabPanel);

	}

	private Widget createPersonelListesiTabContent() {
		table = new FlexTable();
		FlexCellFormatter cellFormatter = table.getFlexCellFormatter();

		table.setCellSpacing(5);
		table.setCellPadding(3);

		cellFormatter.setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_LEFT);
	    table.setWidget(0, 0, new HTML("<b>Ad</b>"));
	    table.setWidget(0, 1, new HTML("<b>Soyad</b>"));
	    table.setWidget(0, 2, new HTML("<b>E-posta</b>"));

		return table;
	}
	
	private void addRow(Personel personel) {
	    int numRows = table.getRowCount();
	    table.setHTML(numRows, 0, personel.getAd());
	    table.setHTML(numRows, 1, personel.getSoyad());
	    table.setHTML(numRows, 2, personel.getEposta());
	  }


	private Widget createPersonelGirisTabContent() {
		VerticalPanel vPanel = new VerticalPanel();
		form = new PersonelGirisFormu();
		Button btnKaydet = new Button("Kaydet");
		btnKaydet.addClickHandler(new KaydetClickHandler());
		
		vPanel.add(form);
		vPanel.add(btnKaydet);
		return vPanel;
	}
	
	class KaydetClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			final Personel personel = form.fromViewToModel();
			demoService.createPersonel(personel, new AsyncCallback<Void>() {

				DialogBox d = new DialogBox(true, true);

				@Override
				public void onFailure(Throwable caught) {
					d.setWidget(new HTML("<b><font color=\"red\">Personel kaydedilirken hata oluştu!</font></b>"));
					d.show();
				}

				@Override
				public void onSuccess(Void result) {
					d.setWidget(new HTML("<b><font color=\"blue\">Personel başarıyla kaydedildi.</font></b>"));
					d.show();
					addRow(personel);
					form.clear();
					tabPanel.selectTab(1);
				}
				
			});
		}

	}
}
