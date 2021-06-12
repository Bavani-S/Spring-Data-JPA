package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {
	@Id
	@Column(name="code")
	private String countryCode;
	@Column(name="name")
	private String countryName;
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@Override
	public String toString() {
		return "Country [countryCode=" + countryCode + ", countryName=" + countryName + "]";
	}
}
