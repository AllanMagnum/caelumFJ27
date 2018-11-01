package br.com.alura.forum.validator.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorOutputDto {

	private List<String> globalErrorMessages = new ArrayList<>();
	private List<FieldErrorOutputDto> fieldErros = new ArrayList<>();
	
	public void addError(String message){
		globalErrorMessages.add(message);
	}
	
	public void addFieldError(String field, String message){
		FieldErrorOutputDto fieldError = new FieldErrorOutputDto(field, message);
		fieldErros.add(fieldError);
	}

	public List<String> getGlobalErrorMessages() {
		return globalErrorMessages;
	}

	public void setGlobalErrorMessages(List<String> globalErrorMessages) {
		this.globalErrorMessages = globalErrorMessages;
	}

	public List<FieldErrorOutputDto> getFieldErros() {
		return fieldErros;
	}

	public void setFieldErros(List<FieldErrorOutputDto> fieldErros) {
		this.fieldErros = fieldErros;
	}
	
	
}