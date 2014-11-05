package com.spring.jqgrid.persistence.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "STATE")
public class StateEntity implements Serializable {
	
	private static final long serialVersionUID = -3606630496613024443L;

	@Id
	@Column(name = "STATE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer state_id;

	@NotEmpty
	@Column(name = "STATE_NAME")
	private String stateName;
	
	@OneToMany(mappedBy="stateEntity")
    private List<CityEntity> cityEntity;

	public List<CityEntity> getCityEntity() {
		return cityEntity;
	}

	public void setCityEntity(List<CityEntity> cityEntity) {
		this.cityEntity = cityEntity;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}