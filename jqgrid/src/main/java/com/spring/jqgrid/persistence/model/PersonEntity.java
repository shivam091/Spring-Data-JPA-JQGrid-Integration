package com.spring.jqgrid.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PERSON_DETAILS")
public class PersonEntity implements Serializable {

	private static final long serialVersionUID = 1231688893531921425L;
	
	@Id
	@Column(name = "PERSON_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long personId;
	
	@NotEmpty
	@Column(name = "PERSON_NAME")
	private String personName;
	
	@NotEmpty
	@Column(name = "PERSON_PASSWORD")
	private String personPassword;
	
	@NotEmpty
	@Column(name = "GENDER")
	private String personGender;
	
	@NotNull
	@Column(name = "PERSON_BIRTH_DATE")
	private String personBirthDate;
	
	@Column(name = "PERSON_DESIGNATION")
	private String personDesignation;
	
	@NotEmpty
	@Column(name = "PERSON_MOBILE_NUMBER", length = 10)
	private String personMobileNumber;
	
	@NotEmpty
	@Column(name = "PERSON_EMAIL_ID", unique = true, length = 40)
	private String personEmailId;
	
	@NotEmpty
	@Column(name = "PERSON_STATE")
	private String personState;
	
	@NotEmpty
	@Column(name = "PERSON_CITY")
	private String personCity;
	
	@NotEmpty
	@Column(name = "PERSON_POSTAL_CODE", length = 6)
	private String personPostalCode;
	
	@NotEmpty
	@Column(name = "PERSON_GIT_URL", length = 50)
	private String personGitUrl;
	
	@NotEmpty
	@Column(name = "PERSON_SKILLS", length = 75)
	private String personSkills;
	
	@NotEmpty
	@Column(name = "PERSON_PROJECT_VALUE", length = 25)
	private String personProjectValue;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonPassword() {
		return personPassword;
	}

	public void setPersonPassword(String personPassword) {
		this.personPassword = personPassword;
	}

	public String getPersonGender() {
		return personGender;
	}

	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}

	public String getPersonBirthDate() {
		return personBirthDate;
	}

	public void setPersonBirthDate(String personBirthDate) {
		this.personBirthDate = personBirthDate;
	}

	public String getPersonDesignation() {
		return personDesignation;
	}

	public void setPersonDesignation(String personDesignation) {
		this.personDesignation = personDesignation;
	}

	public String getPersonMobileNumber() {
		return personMobileNumber;
	}

	public void setPersonMobileNumber(String personMobileNumber) {
		this.personMobileNumber = personMobileNumber;
	}

	public String getPersonEmailId() {
		return personEmailId;
	}

	public void setPersonEmailId(String personEmailId) {
		this.personEmailId = personEmailId;
	}

	public String getPersonState() {
		return personState;
	}

	public void setPersonState(String personState) {
		this.personState = personState;
	}

	public String getPersonCity() {
		return personCity;
	}

	public void setPersonCity(String personCity) {
		this.personCity = personCity;
	}

	public String getPersonPostalCode() {
		return personPostalCode;
	}

	public void setPersonPostalCode(String personPostalCode) {
		this.personPostalCode = personPostalCode;
	}

	public String getPersonGitUrl() {
		return personGitUrl;
	}

	public void setPersonGitUrl(String personGitUrl) {
		this.personGitUrl = personGitUrl;
	}	
	
	public String getPersonSkills() {
		return personSkills;
	}

	public void setPersonSkills(String personSkills) {
		this.personSkills = personSkills;
	}

	public String getPersonProjectValue() {
		return personProjectValue;
	}

	public void setPersonProjectValue(String personProjectValue) {
		this.personProjectValue = personProjectValue;
	}
}