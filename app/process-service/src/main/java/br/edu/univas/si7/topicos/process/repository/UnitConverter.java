package br.edu.univas.si7.topicos.process.repository;

import javax.persistence.AttributeConverter;

import br.edu.univas.si7.topicos.process.entity.CustomerType;

public class UnitConverter implements AttributeConverter<CustomerType, Integer> {
	@Override
	public Integer convertToDatabaseColumn(CustomerType unit) {
		return unit.getCode();
	}

	@Override
	public CustomerType convertToEntityAttribute(Integer code) {
		return CustomerType.getUnit(code);
	}
}