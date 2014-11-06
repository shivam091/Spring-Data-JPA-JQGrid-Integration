package com.spring.jqgrid.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jqgrid.business.service.CityService;
import com.spring.jqgrid.business.service.PersonService;
import com.spring.jqgrid.business.service.StateService;
import com.spring.jqgrid.jqgrid.mappers.JqgridObjectMapper;
import com.spring.jqgrid.jqgrid.mappers.PersonMapper;
import com.spring.jqgrid.jqgrid.util.JQGridTable;
import com.spring.jqgrid.jqgrid.util.JqgridFilter;
import com.spring.jqgrid.jqgrid.util.StatusResponse;
import com.spring.jqgrid.persistence.model.PersonEntity;
import com.spring.jqgrid.web.service.response.PersonResponse;

@RestController
@RequestMapping("/person")
public class PersonRestService {

	@Autowired
	private PersonService personService;

	@Autowired
	private StateService stateService;

	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/getAllPeople.json", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody JQGridTable<PersonResponse> getAllPeople(
			@RequestParam(value = "_search") Boolean search,
			@RequestParam(value = "filters", required = false) String filters,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "sord", required = false) String sord) {
		Pageable pageable = new PageRequest(page - 1, rows);

		// To return filtered records if search is true
		if (search == true) {
			return getFilteredRecords(filters, pageable);
		}

		List<PersonResponse> listOfpeople = new ArrayList<PersonResponse>();

		Page<PersonEntity> persons = null;

		/* To sort locationId in asc order */
		if (sidx.equals("personId") && sord.equals("asc")) {
			persons = personService.getAllPeopleByIdAsc(pageable);
		}

		if (sidx.equals("personId") && sord.equals("desc")) {
			persons = personService.getAllPeopleByIdDesc(pageable);
		}

		JQGridTable<PersonResponse> jQGridTable = new JQGridTable<PersonResponse>();

		listOfpeople = PersonMapper.map(persons);

		if (listOfpeople != null) {
			if (persons.hasContent()) {
				jQGridTable.setRows(persons.getContent());
			}
			jQGridTable.setRecords(Long.valueOf(persons.getTotalElements())
					.toString());
			jQGridTable.setTotal(Integer.valueOf(persons.getTotalPages())
					.toString());
			jQGridTable.setPage(Integer.valueOf(persons.getNumber() + 1)
					.toString());
		}
		return jQGridTable;
	}

	@RequestMapping(value = "/saveNewPerson.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody StatusResponse saveNewPerson(
			@RequestParam(value = "personId", required = true) Integer personId,
			@RequestParam(value = "personName", required = true) String personName,
			@RequestParam(value = "personPassword", required = true) String personPassword,
			@RequestParam(value = "personGender", required = true) String personGender,
			@RequestParam(value = "personBirthDate", required = true) String personBirthDate,
			@RequestParam(value = "personMobileNumber", required = true) String personMobileNumber,
			@RequestParam(value = "personEmailId", required = true) String personEmailId,
			@RequestParam(value = "personDesignation", required = true, defaultValue = "") String personDesignation,
			@RequestParam(value = "personState", required = true) String personState,
			@RequestParam(value = "personCity", required = true) String personCity,
			@RequestParam(value = "personPostalCode", required = true) String personPostalCode,
			@RequestParam(value = "personGitUrl", required = true) String personGitUrl,
			@RequestParam(value = "personSkills", required = true) String personSkills,
			@RequestParam(value = "personProjectValue", required = true, defaultValue = "0.0") String personProjectValue) {

		PersonEntity personEntity = new PersonEntity();

		personEntity.setPersonName(personName);
		personEntity.setPersonPassword(personPassword);
		personEntity.setPersonGender(personGender);
		personEntity.setPersonBirthDate(personBirthDate);
		personEntity.setPersonMobileNumber(personMobileNumber);
		personEntity.setPersonEmailId(personEmailId);
		personEntity.setPersonDesignation(personDesignation);
		personEntity.setPersonState(personState);
		personEntity.setPersonCity(personCity);
		personEntity.setPersonPostalCode(personPostalCode);
		personEntity.setPersonGitUrl(personGitUrl);
		personEntity.setPersonSkills(personSkills);
		personEntity.setPersonProjectValue(personProjectValue);

		if (personService.savePerson(personEntity) != null) {
			return new StatusResponse(true, "New Person is added successfully.");
		} else {
			return new StatusResponse(false, "New person added successfully.");
		}
	}

	@RequestMapping(value = "/editPerson.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody StatusResponse editPerson(
			@RequestParam(value = "personId", required = true) Long personId,
			@RequestParam(value = "personName", required = true) String personName,
			@RequestParam(value = "personPassword", required = true) String personPassword,
			@RequestParam(value = "personGender", required = true) String personGender,
			@RequestParam(value = "personBirthDate", required = true) String personBirthDate,
			@RequestParam(value = "personMobileNumber", required = true) String personMobileNumber,
			@RequestParam(value = "personEmailId", required = true) String personEmailId,
			@RequestParam(value = "personDesignation", required = true, defaultValue = "") String personDesignation,
			@RequestParam(value = "personState", required = true) String personState,
			@RequestParam(value = "personCity", required = true) String personCity,
			@RequestParam(value = "personPostalCode", required = true) String personPostalCode,
			@RequestParam(value = "personGitUrl", required = true) String personGitUrl,
			@RequestParam(value = "personSkills", required = true) String personSkills,
			@RequestParam(value = "personProjectValue", required = true,  defaultValue = "0.0") String personProjectValue) {

		PersonEntity personEntity = personService.findPersonById(personId);
		if (personEntity == null) {
			return new StatusResponse(false, "No person found in records.");
		}

		personEntity.setPersonName(personName);
		personEntity.setPersonPassword(personPassword);
		personEntity.setPersonGender(personGender);
		personEntity.setPersonBirthDate(personBirthDate);
		personEntity.setPersonMobileNumber(personMobileNumber);
		personEntity.setPersonEmailId(personEmailId);
		personEntity.setPersonDesignation(personDesignation);
		personEntity.setPersonState(personState);
		personEntity.setPersonCity(personCity);
		personEntity.setPersonPostalCode(personPostalCode);
		personEntity.setPersonGitUrl(personGitUrl);
		personEntity.setPersonSkills(personSkills);
		personEntity.setPersonProjectValue(personProjectValue);

		if (personService.savePerson(personEntity) != null) {
			return new StatusResponse(true, "person is updated successfully.");
		} else {
			return new StatusResponse(false, "person update failed.");
		}
	}

	@RequestMapping(value = "/deletePerson.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody StatusResponse deletePerson(
			@RequestParam(value = "personId", required = true) Long personId) {

		personService.deletePersonById(personId);

		if (personService.findPersonById(personId) == null) {
			return new StatusResponse(true, "person is deleted successfully.");
		} else {
			return new StatusResponse(false, "person delete failed.");
		}
	}

	@RequestMapping(value = "/getStateList.json", produces = "application/json", method = RequestMethod.GET)
	private @ResponseBody String getStateList() {
		List<String> listOfStates = new ArrayList<String>();
		String states = "";

		listOfStates = stateService.getAllStates();

		states += "<select>";
		states += "<option value='Select State'>Select State</option>";
		if (listOfStates.size() > 0) {
			for (int i = 0; i < listOfStates.size(); i++) {
				states += "<option value='" + listOfStates.get(i) + "'>"
						+ listOfStates.get(i) + "</option>";
			}
			states += "</select>";
		}
		return states;
	}

	@RequestMapping(value = "getAllCities.json", produces = "application/json", method = RequestMethod.GET)
	private @ResponseBody String getCityListForSelectedState() {
		List<String> listOfCities = new ArrayList<String>();
		String cities = "";

		listOfCities = cityService.getAllCityNames();

		cities += "<select>";
		cities += "<option value='Select City'>Select City</option>";

		if (listOfCities.size() > 0) {
			for (int i = 0; i < listOfCities.size(); i++) {
				cities += "<option value=" + listOfCities.get(i) + ">"
						+ listOfCities.get(i) + "</option>";
			}
			cities += "</select>";
		}

		return cities;
	}

	@RequestMapping(value = "/getSkillsList.json", produces = "application/json", method = RequestMethod.GET)
	private @ResponseBody String getSkillsList() {
		String skills = "<select>"
				+ "<option value='C'>C</option>"
				+ "<option value='C++'>C++</option>"
				+ "<optgroup label='J2SE'>"
				+ "<option value='Multithreading'>Multithreading</option>"
				+ "<option value='Collections'>Collections</option>"
				+ "<option value='Networking'>Networking</option>"
				+ "<option value='Swing'>Swing</option>" + "</optgroup>"
				+ "<optgroup label='J2EE'>"
				+ "<option value='JDBC'>JDBC</option>"
				+ "<option value='Servlet'>Servlet</option>"
				+ "<option value='JSP'>JSP</option>"
				+ "<option value='EJB'>EJB</option>"
				+ "<option value='Web Services'>Web Services</option>"
				+ "</optgroup>" + "<option value='C#'>C#</option>"
				+ "<option value='HTML'>HTML</option>"
				+ "<option value='JavaScript'>JavaScript</option>"
				+ "<option value='CSS'>CSS</option>"
				+ "<option value='JQuery'>JQuery</option>"
				+ "<option value='Joomla'>Joomla</option>"
				+ "<option value='Python'>Python</option>" + "</select>";
		return skills;
	}

	private JQGridTable<PersonResponse> getFilteredRecords(String filters,
			Pageable pageable) {

		String personId = null;
		String personGender = null;
		String personBirthDate = null;
		String personMobileNumber = null;
		String personEmailId = null;
		String personDesignation = null;
		String personState = null;
		String personCity = null;
		String personPostalCode = null;
		String personGitUrl = null;
		String personProjectValue = null;

		String personIdOp = null;
		String personGenderOp = null;
		String personBirthDateOp = null;
		String personMobileNumberOp = null;
		String personEmailIdOp = null;
		String personDesignationOp = null;
		String personStateOp = null;
		String personCityOp = null;
		String personPostalCodeOp = null;
		String personGitUrlOp = null;
		String personProjectValueOp = null;

		JqgridFilter jqgridFilter = JqgridObjectMapper.map(filters);
		String groupOp = jqgridFilter.getGroupOp();

		for (JqgridFilter.Rule rule : jqgridFilter.getRules()) {
			if (rule.getField().equals("personId")) {
				personId = rule.getData();
				personIdOp = rule.getOp();
			} else if (rule.getField().equals("personGender")) {
				personGender = rule.getData();
				personGenderOp = rule.getOp();
			} else if (rule.getField().equals("personBirthDate")) {
				personBirthDate = rule.getData();
				personBirthDateOp = rule.getOp();
			} else if (rule.getField().equals("personMobileNumber")) {
				personMobileNumber = rule.getData();
				personMobileNumberOp = rule.getOp();
			} else if (rule.getField().equals("personEmailId")) {
				personEmailId = rule.getData();
				personEmailIdOp = rule.getOp();
			} else if (rule.getField().equals("personDesignation")) {
				personDesignation = rule.getData();
				personDesignationOp = rule.getOp();
			} else if (rule.getField().equals("personState")) {
				personState = rule.getData();
				personStateOp = rule.getOp();
			} else if (rule.getField().equals("personCity")) {
				personCity = rule.getData();
				personCityOp = rule.getOp();
			} else if (rule.getField().equals("personPostalCode")) {
				personPostalCode = rule.getData();
				personPostalCodeOp = rule.getOp();
			} else if (rule.getField().equals("personGitUrl")) {
				personGitUrl = rule.getData();
				personGitUrlOp = rule.getOp();
			} else if (rule.getField().equals("personProjectValue")) {
				personProjectValue = rule.getData();
				personProjectValueOp = rule.getOp();
			}
		}

		Page<PersonEntity> people = null;

		/* start search queries */
		/* personMobileNumber equals */
		if (personMobileNumber != null && personMobileNumberOp.equals("eq")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonMobileNumberEq(
					personMobileNumber, pageable);
		}
		/* personEmailId equals */
		if (personEmailId != null && personEmailIdOp.equals("eq")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonEmailIdEq(personEmailId,
					pageable);
		}
		/* personState equals */
		if (personState != null && personStateOp.equals("eq")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonStateEq(personState,
					pageable);
		}
		/* personCity equals */
		if (personCity != null && personCityOp.equals("eq")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonCityEq(personCity,
					pageable);
		}
		/* personGender equals */
		if (personGender != null && personGenderOp.equals("eq")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonGenderEq(personGender,
					pageable);
		}
		/* personId equals */
		if (personId != null && personIdOp.equals("eq")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonIdEq(
					Long.parseLong(personId), pageable);
		}
		/* personId begins with */
		if (personId != null && personIdOp.equals("bw")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonIdBw(
					Long.parseLong(personId), pageable);
		}
		/* personId ends with */
		if (personId != null && personIdOp.equals("ew")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonIdEw(
					Long.parseLong(personId), pageable);
		}
		/* personId less than */
		if (personId != null && personIdOp.equals("lt")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonIdLt(
					Long.parseLong(personId), pageable);
		}
		/* personId greater than */
		if (personId != null && personIdOp.equals("gt")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonIdGt(
					Long.parseLong(personId), pageable);
		}
		/* persionGitUrl equals */
		if (personGitUrl != null && personGitUrlOp.equals("eq")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonGitUrlEq(personGitUrl,
					pageable);
		}
		/* personPostalCode equals */
		if (personPostalCode != null && personPostalCodeOp.equals("eq")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonPostalCodeEq(
					personPostalCode, pageable);
		}
		/* personPostalCode begins with */
		if (personPostalCode != null && personPostalCodeOp.equals("bw")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonPostalCodeBw(
					personPostalCode, pageable);
		}
		/* personPostalCode ends with */
		if (personPostalCode != null && personPostalCodeOp.equals("ew")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonPostalCodeEw(
					personPostalCode, pageable);
		}
		/* personDesignation equals */
		if (personDesignation != null && personDesignationOp.equals("eq")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonDesignationEq(
					personDesignation, pageable);
		}
		/* personDesignation begins with */
		if (personDesignation != null && personDesignationOp.equals("bw")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonDesignationBw(
					personDesignation, pageable);
		}
		/* personDesignation ends with */
		if (personDesignation != null && personDesignationOp.equals("ew")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonDesignationEw(
					personDesignation, pageable);
		}
		/* personProjectValue equals */
		if (personProjectValue != null && personProjectValueOp.equals("eq")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonProjectValueEq(
					personProjectValue, pageable);
		}
		/* personProjectValue begins with */
		if (personProjectValue != null && personProjectValueOp.equals("gt")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonProjectValueGt(
					personProjectValue, pageable);
		}
		/* personProjectValue ends with */
		if (personProjectValue != null && personProjectValueOp.equals("lt")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonProjectValueLt(
					personProjectValue, pageable);
		}
		/* persionBirthDate equals */
		if (personBirthDate != null && personBirthDateOp.equals("eq")
				&& groupOp.equals("AND")) {
			people = personService.getAllPeopleByPersonBirthDateEq(
					personBirthDate, pageable);
		}
		/* if no search criteria defined ==> load all records */
		if (personCity.equals("Select City")
				&& personState.equals("Select State") && personId == null
				&& personBirthDate == null && personDesignation == null
				&& personMobileNumber == null && personEmailId == null
				&& personGender == null && personGitUrl == null
				&& personPostalCode == null && personProjectValue == null) {
			people = personService.getAllPeopleByIdAsc(pageable);
		}
		/* end search queries */

		List<PersonResponse> personResponses = PersonMapper.map(people);
		JQGridTable<PersonResponse> searchedPeople = new JQGridTable<PersonResponse>();

		if (people != null) {
			if (people.hasContent()) {
				searchedPeople.setRows(personResponses);
			}
			searchedPeople.setRecords(Long.valueOf(people.getTotalElements())
					.toString());
			searchedPeople.setTotal(Integer.valueOf(people.getTotalPages())
					.toString());
			searchedPeople.setPage(Integer.valueOf(people.getNumber() + 1)
					.toString());
		}
		return searchedPeople;
	}
}