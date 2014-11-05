package com.spring.jqgrid.business.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jqgrid.persistence.model.PersonEntity;
import com.spring.jqgrid.persistence.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@PersistenceContext(unitName = "hibernatePersistenceUnit")
	private EntityManager entityManager;

	/* start JQGrid search queries */

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByIdAsc(Pageable pageable) {
		return personRepository.getAllPeopleByIdAsc(pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByIdDesc(Pageable pageable) {
		return personRepository.getAllPeopleByIdDesc(pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonMobileNumberEq(
			String personMobileNumber, Pageable pageable) {
		return personRepository.getAllPeopleByPersonMobileNumberEq(
				personMobileNumber, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonEmailIdEq(
			String personEmailId, Pageable pageable) {
		return personRepository.getAllPeopleByPersonEmailIdEq(personEmailId,
				pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonStateEq(String Peopletate,
			Pageable pageable) {
		return personRepository.getAllPeopleByPersonStateEq(Peopletate,
				pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonCityEq(String personCity,
			Pageable pageable) {
		return personRepository
				.getAllPeopleByPersonCityEq(personCity, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonGenderEq(String personGender,
			Pageable pageable) {
		return personRepository.getAllPeopleByPersonGenderEq(personGender,
				pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonIdEq(Long personId,
			Pageable pageable) {
		return personRepository.getAllPeopleByPersonIdEq(personId, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonIdBw(Long personId,
			Pageable pageable) {
		return personRepository.getAllPeopleByPersonIdBw(personId, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonIdEw(Long personId,
			Pageable pageable) {
		return personRepository.getAllPeopleByPersonIdEw(personId, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonIdLt(Long personId,
			Pageable pageable) {
		return personRepository.getAllPeopleByPersonIdLt(personId, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonIdGt(Long personId,
			Pageable pageable) {
		return personRepository.getAllPeopleByPersonIdGt(personId, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonGitUrlEq(String personGitUrl,
			Pageable pageable) {
		return personRepository.getAllPeopleByPersonGitUrlEq(personGitUrl,
				pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonPostalCodeEq(
			String personPostalCode, Pageable pageable) {
		return personRepository.getAllPeopleByPersonPostalCodeEq(
				personPostalCode, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonPostalCodeBw(
			String personPostalCode, Pageable pageable) {
		return personRepository.getAllPeopleByPersonPostalCodeBw(
				personPostalCode, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonPostalCodeEw(
			String personPostalCode, Pageable pageable) {
		return personRepository.getAllPeopleByPersonPostalCodeEw(
				personPostalCode, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonDesignationEq(
			String personDesignation, Pageable pageable) {
		return personRepository.getAllPeopleByPersonDesignationEq(
				personDesignation, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonDesignationBw(
			String personDesignation, Pageable pageable) {
		return personRepository.getAllPeopleByPersonDesignationBw(
				personDesignation, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonDesignationEw(
			String personDesignation, Pageable pageable) {
		return personRepository.getAllPeopleByPersonDesignationEw(
				personDesignation, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonProjectValueEq(
			String personProjectValue, Pageable pageable) {
		return personRepository.getAllPeopleByPersonProjectValueEq(
				personProjectValue, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonProjectValueLt(
			String personProjectValue, Pageable pageable) {
		return personRepository.getAllPeopleByPersonProjectValueLt(
				personProjectValue, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonProjectValueGt(
			String personProjectValue, Pageable pageable) {
		return personRepository.getAllPeopleByPersonProjectValueGt(
				personProjectValue, pageable);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<PersonEntity> getAllPeopleByPersonBirthDateEq(
			String personBirthDate, Pageable pageable) {
		return personRepository.getAllPeopleByPersonBirthDateEq(
				personBirthDate, pageable);
	}

	/* end JQGrid search queries */

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public PersonEntity savePerson(PersonEntity personEntity) {
		return personRepository.saveAndFlush(personEntity);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public PersonEntity findPersonByEmailId(String personEmailId) {
		return personRepository.findPersonByEmailId(personEmailId);
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public PersonEntity findPersonById(Long personId) {
		return personRepository.findOne(personId);
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void deletePersonById(Long personId) {
		personRepository.delete(personId);
	}
}
