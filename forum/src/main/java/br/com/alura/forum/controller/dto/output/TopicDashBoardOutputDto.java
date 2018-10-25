package br.com.alura.forum.controller.dto.output;

import java.util.List;

import br.com.alura.forum.model.Category;

public class TopicDashBoardOutputDto {
	private String categoryName;
	private List<Category> subcategories;
	private Long allTopics;
	private Long lastWeekTopics;
	private Long unansweredTopics;
	
	public TopicDashBoardOutputDto() {
		super();
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Category> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<Category> subcategories) {
		this.subcategories = subcategories;
	}
	public Long getAllTopics() {
		return allTopics;
	}
	public void setAllTopics(Long allTopics) {
		this.allTopics = allTopics;
	}
	public Long getLastWeekTopics() {
		return lastWeekTopics;
	}
	public void setLastWeekTopics(Long lastWeekTopics) {
		this.lastWeekTopics = lastWeekTopics;
	}
	public Long getUnansweredTopics() {
		return unansweredTopics;
	}
	public void setUnansweredTopics(Long unansweredTopics) {
		this.unansweredTopics = unansweredTopics;
	}
	
	

}
