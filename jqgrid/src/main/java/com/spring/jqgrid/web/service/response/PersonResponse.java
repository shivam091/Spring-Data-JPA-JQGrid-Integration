package com.spring.jqgrid.web.service.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PersonResponse")
public class PersonResponse implements Serializable {

	private static final long serialVersionUID = 408261994903394113L;

	private Long personId;
	
	private String personName;
	
	private String personPassword;
	
	private String personGender;
	
	private String personBirthDate;
	
	private String personDesignation;
	
	private String personMobileNumber;
	
	private String personEmailId;
	
	private String personState;
	
	private String personCity;
	
	private String personPostalCode;
	
	private String personGitUrl;
	
	private String personSkills;
	
	private String personProjectValue;

	@XmlElement
	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	@XmlElement
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@XmlElement
	public String getPersonPassword() {
		return personPassword;
	}

	public void setPersonPassword(String personPassword) {
		this.personPassword = personPassword;
	}

	@XmlElement
	public String getPersonGender() {
		return personGender;
	}

	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}

	@XmlElement
	public String getPersonBirthDate() {
		return personBirthDate;
	}

	public void setPersonBirthDate(String personBirthDate) {
		this.personBirthDate = personBirthDate;
	}

	@XmlElement
	public String getPersonDesignation() {
		return personDesignation;
	}

	public void setPersonDesignation(String personDesignation) {
		this.personDesignation = personDesignation;
	}

	@XmlElement
	public String getPersonMobileNumber() {
		return personMobileNumber;
	}

	public void setPersonMobileNumber(String personMobileNumber) {
		this.personMobileNumber = personMobileNumber;
	}

	@XmlElement
	public String getPersonEmailId() {
		return personEmailId;
	}

	public void setPersonEmailId(String personEmailId) {
		this.personEmailId = personEmailId;
	}

	@XmlElement
	public String getPersonState() {
		return personState;
	}

	public void setPersonState(String personState) {
		this.personState = personState;
	}

	@XmlElement
	public String getPersonCity() {
		return personCity;
	}

	public void setPersonCity(String personCity) {
		this.personCity = personCity;
	}

	@XmlElement
	public String getPersonPostalCode() {
		return personPostalCode;
	}

	public void setPersonPostalCode(String personPostalCode) {
		this.personPostalCode = personPostalCode;
	}

	@XmlElement
	public String getPersonGitUrl() {
		return personGitUrl;
	}

	public void setPersonGitUrl(String personGitUrl) {
		this.personGitUrl = personGitUrl;
	}

	@XmlElement
	public String getPersonSkills() {
		return personSkills;
	}

	public void setPersonSkills(String personSkills) {
		this.personSkills = personSkills;
	}	
	
	@XmlElement
	public String getPersonProjectValue() {
		return personProjectValue;
	}

	public void setPersonProjectValue(String personProjectValue) {
		this.personProjectValue = personProjectValue;
	}
}