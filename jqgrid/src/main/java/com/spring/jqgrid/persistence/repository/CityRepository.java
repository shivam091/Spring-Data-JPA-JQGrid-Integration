package com.spring.jqgrid.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.spring.jqgrid.persistence.model.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {
	
	@Query("SELECT c.cityName From CityEntity c ORDER BY c.stateEntity.state_id ASC")
	public List<String> getAllCityNames();
}
