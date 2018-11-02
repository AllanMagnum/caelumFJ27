package br.com.alura.forum.controller.dto.output;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.controller.dto.AnswerDto;
import br.com.alura.forum.model.topic_domain.Topic;

public class TopicAnswerOutputDto {
	
	private Long id;
	private String shortDescription;
	private String content;
	private String status;
	private Instant creationIsntant;
	private Instant lastUpdate;
	private String courseName;
	private String subcategoryName;
	private String categoryName;
	private String ownerName;
	private Integer numbersOfResponses;
	private List<AnswerDto> answers;

	public TopicAnswerOutputDto(Topic topic) {
		this.id = topic.getId();
		this.shortDescription = topic.getShortDescription();
		this.ownerName = topic.getOwner().getName();
		this.courseName =topic.getCourse().getName();
		this.subcategoryName = topic.getCourse().getSubcategory().getName();
		this.categoryName = topic.getCourse().getCategoryName();
		this.numbersOfResponses = topic.getNumberOfAnswers();
		this.answers = topic.getAnswers().stream().map(AnswerDto::new).collect(Collectors.toList()); 
	}

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

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Integer getNumbersOfResponses() {
		return numbersOfResponses;
	}

	public void setNumbersOfResponses(Integer numbersOfResponses) {
		this.numbersOfResponses = numbersOfResponses;
	}

	public List<AnswerDto> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDto> answers) {
		this.answers = answers;
	}

	
}
