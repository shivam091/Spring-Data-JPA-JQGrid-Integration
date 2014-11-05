package com.spring.jqgrid.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jqgrid.business.service.PersonService;
import com.spring.jqgrid.persistence.model.PersonEntity;

@RestController
@RequestMapping("/person")
public class PersonValidator {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/checkEmailIdForUnique.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody Boolean checkEmailIdForUnique(
			@RequestParam("personEmailId") String personEmailId) {

		PersonEntity personEntity = personService.findPersonByEmailId(personEmailId);

		if (personEntity != null) {
			return true;
		} else {
			return false;
		}
	}
}
