package br.com.alura.forum.controller.dto.input;

import java.time.Instant;
import java.util.List;

import br.com.alura.forum.controller.dto.AnswerDto;

public class NewAnswerInputDto {
	
	private Long id;
	private String shortDescription;
	private String content;
	private String status;
	private Instant creationIsntant;
	private Instant lastUpdate;
	private String courseName;
	private String subCategoryName;
	private String ownerName;
	private Long numbersOfResponses;
	private List<AnswerDto> answers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getCreationIsntant() {
		return creationIsntant;
	}

	public void setCreationIsntant(Instant creationIsntant) {
		this.creationIsntant = creationIsntant;
	}

	public Instant getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Instant lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Long getNumbersOfResponses() {
		return numbersOfResponses;
	}

	public void setNumbersOfResponses(Long numbersOfResponses) {
		this.numbersOfResponses = numbersOfResponses;
	}

	public List<AnswerDto> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDto> answers) {
		this.answers = answers;
	}
}
