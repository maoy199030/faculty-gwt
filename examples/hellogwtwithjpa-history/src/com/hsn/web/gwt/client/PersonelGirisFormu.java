package com.hsn.web.gwt.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.hsn.web.gwt.client.model.Personel;

public class PersonelGirisFormu extends Composite {

	private TextBox txtAd;
	private TextBox txtSoyad;
	private TextBox txtEposta;

	public PersonelGirisFormu() {
		super();
		
		initWidget(createForm());
	}

	private Widget createForm() {
		FlexTable form = new FlexTable();
		form.setCellSpacing(6);
		FlexCellFormatter flexCellFormatter = form.getFlexCellFormatter();
		
		// Baslik
		form.setHTML(0, 0, "Personel Bilgileri");
		flexCellFormatter.setColSpan(0, 0, 2);
		flexCellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		
		form.setWidget(1, 0, new HTML("Ad"));
		txtAd = new TextBox();
		txtSoyad = new TextBox();
		txtEposta = new TextBox();
		form.setWidget(1, 1, txtAd);
		form.setHTML(2, 0, "Soyad");
		form.setWidget(2, 1, txtSoyad);
		form.setHTML(3, 0, "E-posta");
		form.setWidget(3, 1, txtEposta);
		
		DecoratorPanel decoratorPanel = new DecoratorPanel();
		decoratorPanel.setWidget(form);
		
		return decoratorPanel;
	}

	public Personel fromViewToModel() {
		Personel p = new Personel();
		p.setAd(txtAd.getText());
		p.setSoyad(txtSoyad.getText());
		p.setEposta(txtEposta.getText());
		return p;
	}

	public void clear() {
		txtAd.setText(null);
		txtSoyad.setText(null);
		txtEposta.setText(null);
	}

}
