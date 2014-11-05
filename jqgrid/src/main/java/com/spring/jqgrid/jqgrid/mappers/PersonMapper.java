package com.spring.jqgrid.jqgrid.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.spring.jqgrid.persistence.model.PersonEntity;
import com.spring.jqgrid.web.service.response.PersonResponse;

public class PersonMapper {
	
	public static PersonResponse map(PersonEntity personEntity) {
		PersonResponse personResponse = new PersonResponse();
		personResponse.setPersonId(personEntity.getPersonId());
		personResponse.setPersonName(personEntity.getPersonName());
		personResponse.setPersonPassword(personResponse.getPersonPassword());
		personResponse.setPersonGender(personEntity.getPersonGender());
		personResponse.setPersonBirthDate(personEntity.getPersonBirthDate());
		personResponse.setPersonDesignation(personEntity.getPersonDesignation());
		personResponse.setPersonMobileNumber(personEntity.getPersonMobileNumber());
		personResponse.setPersonEmailId(personEntity.getPersonEmailId());
		personResponse.setPersonState(personEntity.getPersonState());
		personResponse.setPersonCity(personEntity.getPersonCity());
		personResponse.setPersonPostalCode(personEntity.getPersonPostalCode());
		personResponse.setPersonGitUrl(personEntity.getPersonGitUrl());
		personResponse.setPersonSkills(personEntity.getPersonSkills());
		personResponse.setPersonProjectValue(personEntity.getPersonProjectValue());
		return personResponse;
	}
	
	public static List<PersonResponse> map(Page<PersonEntity> people) {
		List<PersonResponse> personResponses = new ArrayList<PersonResponse>();
		for (PersonEntity person : people) {
			personResponses.add(map(person));
		}
		return personResponses;
	}
}