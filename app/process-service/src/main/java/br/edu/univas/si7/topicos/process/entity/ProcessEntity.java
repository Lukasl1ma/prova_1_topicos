package br.edu.univas.si7.topicos.process.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data

public class ProcessEntity {

	public ProcessEntity(String code, String responsable, String lastReviewCode, String durationInMinute, String meanCost, Boolean active) {
		super();
		this.code = code;
		this.responsable = responsable;
		this.lastReviewCode = lastReviewCode;
		this.durationInMinute = durationInMinute;
		this.meanCost = meanCost;
		this.active = active;
	}

	@Id
	@Column(name = "code")
	private String code;

	@Column(name = "responsable")
	private String responsable;

	@Column(name = "lastReviewCode")
	private String lastReviewCode;

	@Column(name = "durationInMinute")
	private String durationInMinute;
	
	@Column(name = "meanCost")
	private String  meanCost;

	@Column(name = "active")
	private Boolean  active;
	
}
