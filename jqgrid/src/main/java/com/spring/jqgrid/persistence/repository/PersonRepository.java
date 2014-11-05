package com.spring.jqgrid.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.jqgrid.persistence.model.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

	/* start JQGrid search & sorting methods */
	@Query("SELECT p FROM PersonEntity p ORDER BY personId ASC")
	Page<PersonEntity> getAllPeopleByIdAsc(Pageable pageable);

	@Query("SELECT p FROM PersonEntity p ORDER BY personId DESC")
	Page<PersonEntity> getAllPeopleByIdDesc(Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personMobileNumber = :personMobileNumber")
	Page<PersonEntity> getAllPeopleByPersonMobileNumberEq(
			@Param("personMobileNumber") String personMobileNumber,
			Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personEmailId = :personEmailId")
	Page<PersonEntity> getAllPeopleByPersonEmailIdEq(
			@Param("personEmailId") String personEmailId, Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personState = :personState")
	Page<PersonEntity> getAllPeopleByPersonStateEq(
			@Param("personState") String personState, Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personCity = :personCity")
	Page<PersonEntity> getAllPeopleByPersonCityEq(
			@Param("personCity") String personCity, Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personGender = :personGender")
	Page<PersonEntity> getAllPeopleByPersonGenderEq(
			@Param("personGender") String personGender, Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personId = :personId")
	Page<PersonEntity> getAllPeopleByPersonIdEq(
			@Param("personId") Long personId, Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personId LIKE CONCAT(:personId, '%')")
	Page<PersonEntity> getAllPeopleByPersonIdBw(
			@Param("personId") Long personId, Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personId LIKE CONCAT('%', :personId)")
	Page<PersonEntity> getAllPeopleByPersonIdEw(
			@Param("personId") Long personId, Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personId < :personId")
	Page<PersonEntity> getAllPeopleByPersonIdLt(
			@Param("personId") Long personId, Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personId > :personId")
	Page<PersonEntity> getAllPeopleByPersonIdGt(
			@Param("personId") Long personId, Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personGitUrl = :personGitUrl")
	Page<PersonEntity> getAllPeopleByPersonGitUrlEq(
			@Param("personGitUrl") String personGitUrl, Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personPostalCode = :personPostalCode")
	Page<PersonEntity> getAllPeopleByPersonPostalCodeEq(
			@Param("personPostalCode") String personPostalCode,
			Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personPostalCode LIKE CONCAT(:personPostalCode, '%')")
	Page<PersonEntity> getAllPeopleByPersonPostalCodeBw(
			@Param("personPostalCode") String personPostalCode,
			Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personPostalCode LIKE CONCAT('%', :personPostalCode)")
	Page<PersonEntity> getAllPeopleByPersonPostalCodeEw(
			@Param("personPostalCode") String personPostalCode,
			Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personDesignation = :personDesignation)")
	Page<PersonEntity> getAllPeopleByPersonDesignationEq(
			@Param("personDesignation") String personDesignation,
			Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personDesignation LIKE CONCAT(:personDesignation, '%')")
	Page<PersonEntity> getAllPeopleByPersonDesignationBw(
			@Param("personDesignation") String personDesignation,
			Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personDesignation LIKE CONCAT('%', :personDesignation)")
	Page<PersonEntity> getAllPeopleByPersonDesignationEw(
			@Param("personDesignation") String personDesignation,
			Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personProjectValue = :personProjectValue")
	Page<PersonEntity> getAllPeopleByPersonProjectValueEq(
			@Param("personProjectValue") String personProjectValue,
			Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personProjectValue > :personProjectValue")
	Page<PersonEntity> getAllPeopleByPersonProjectValueGt(
			@Param("personProjectValue") String personProjectValue,
			Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personProjectValue < :personProjectValue")
	Page<PersonEntity> getAllPeopleByPersonProjectValueLt(
			@Param("personProjectValue") String personDesignation,
			Pageable pageable);

	@Query("SELECT p FROM PersonEntity p WHERE p.personBirthDate = :personBirthDate")
	Page<PersonEntity> getAllPeopleByPersonBirthDateEq(
			@Param("personBirthDate") String personBirthDate, Pageable pageable);

	/* end JQGrid search & sorting methods */

	@Query("SELECT p FROM PersonEntity p WHERE p.personId = :personId")
	PersonEntity findOne(@Param("personId") Long personId);

	@Query("SELECT p FROM PersonEntity p WHERE p.personEmailId = :personEmailId")
	PersonEntity findPersonByEmailId(
			@Param("personEmailId") String personEmailId);

}
