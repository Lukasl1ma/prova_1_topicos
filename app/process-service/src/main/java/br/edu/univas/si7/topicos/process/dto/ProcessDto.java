package br.edu.univas.si7.topicos.process.dto;

import br.edu.univas.si7.topicos.process.entity.ProcessEntity;
import br.edu.univas.si7.topicos.process.entity.CustomerType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProcessDto {

	private String code;
	private String responsable;
	private String lastReviewCode;
	private String durationInMinute;
	private String meanCost;
	private Boolean active;

	public ProcessDto(ProcessEntity process) {
		this.code = process.getCode();
		this.responsable = process.getResponsable();
		this.lastReviewCode = process.getLastReviewCode();
		this.durationInMinute = process.getDurationInMinute();
		this.meanCost = process.getMeanCost();
		this.active = process.getActive();
	}
}
