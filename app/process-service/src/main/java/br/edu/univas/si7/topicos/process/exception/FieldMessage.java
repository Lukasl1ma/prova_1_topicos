package br.edu.univas.si7.topicos.process.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FieldMessage {

	String fieldName;
	String message;

}
