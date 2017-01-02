package org.professionalprofile.core.enums;

import java.util.Locale;

public enum Language {
	
	EN(1, new Locale("en", "US")), 
	PT(2, new Locale("pt", "BR"));

	private Integer id;
	private Locale locale;

	private Language(Integer id, Locale locale) {
		this.id = id;
		this.locale = locale;
	}

	public Integer getId() {
		return id;
	}

	public Locale getLocale() {
		return locale;
	}

}
