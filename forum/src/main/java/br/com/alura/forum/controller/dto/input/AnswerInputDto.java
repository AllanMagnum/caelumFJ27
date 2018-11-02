package br.com.alura.forum.controller.dto.input;

public class AnswerInputDto {
	private String content;

	public AnswerInputDto(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
