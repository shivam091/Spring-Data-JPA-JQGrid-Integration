package com.spring.jqgrid.persistence.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CITY")
public class CityEntity implements Serializable {

	private static final long serialVersionUID = -3676531231427934594L;

	@Id
	@Column(name = "CITY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cityId;

	@NotEmpty
	@Column(name = "CITY_NAME")
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name="STATE_ID",nullable=false )
	private StateEntity stateEntity;
		
	public StateEntity getStateEntity() {
		return stateEntity;
	}

	public void setStateEntity(StateEntity stateEntity) {
		this.stateEntity = stateEntity;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}