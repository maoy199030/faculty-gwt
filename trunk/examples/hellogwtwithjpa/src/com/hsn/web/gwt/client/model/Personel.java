package com.hsn.web.gwt.client.model;



public class Personel implements BaseDemoObject {
	
	// don't exchange these fields in RPC calls
	public transient final String NAMEDQUERY_FIND_PERSONEL_BY_EMAIL = "Personel.findPersonelByEmail";

	private int id;
	private String ad;
	private String soyad;
	private String eposta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getEposta() {
		return eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof Personel) {
			Personel p = (Personel) obj;
			return eposta.equals(p.getEposta());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 23+eposta.hashCode();
	}

	@Override
	public String toString() {
		return ad + " " + soyad;
	}

}
