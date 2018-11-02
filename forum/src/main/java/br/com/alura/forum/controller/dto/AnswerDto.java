package br.com.alura.forum.controller.dto;

import java.time.Instant;

import br.com.alura.forum.model.Answer;

public class AnswerDto {

	private Long id;
	private String content;
	private Instant creationTime;
	private String ownerName;
	
	public AnswerDto(Answer answer) {
		this.id = answer.getId();
		this.content = answer.getContent();
		this.creationTime = answer.getCreationTime();
		this.ownerName = answer.getOwnerName();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Instant getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Instant creationTime) {
		this.creationTime = creationTime;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	
}
