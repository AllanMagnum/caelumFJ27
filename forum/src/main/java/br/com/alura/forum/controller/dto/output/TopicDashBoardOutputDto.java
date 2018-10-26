package br.com.alura.forum.controller.dto.output;

import java.util.ArrayList;
import java.util.List;

public class TopicDashBoardOutputDto {
	private String categoryName;
	private List<String> subcategories = new ArrayList<>();
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
	public List<String> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<String> subcategories) {
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