package br.com.alura.forum.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.forum.controller.dto.output.TopicDashBoardOutputDto;
import br.com.alura.forum.controller.repository.TopicRepository;
import br.com.alura.forum.model.topic_domain.Topic;

@Component
public class TopicBO {

	@Autowired
	private TopicRepository topicRepository;
	
	
	public List<TopicDashBoardOutputDto> findAllCategory(){ 
		
		List<TopicDashBoardOutputDto> list = new ArrayList<>();
		
		List<Topic> allTopics = topicRepository.findAll();
		
		for (Topic topic : allTopics) {
			List<Topic> topics = topicRepository.findAllCategory(topic.getCourse().getSubcategory());
			
			TopicDashBoardOutputDto topicDashBoardOutputDto = new TopicDashBoardOutputDto();
			
			topicDashBoardOutputDto.setAllTopics((long) topics.size());			
			
			for (Topic topic2 : topics) {
				topicDashBoardOutputDto.getSubcategories().add(topic2.getCourse().getSubcategory());
			}		
			
			list.add(topicDashBoardOutputDto);
		}
		
		return list;
	}
}
