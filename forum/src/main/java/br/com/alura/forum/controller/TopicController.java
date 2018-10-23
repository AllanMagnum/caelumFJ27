package br.com.alura.forum.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto;
import br.com.alura.forum.controller.repository.TopicRepository;
import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.topic_domain.Topic;

@RestController
public class TopicController {
	
	
	@Autowired
	private TopicRepository topicRepository;
	
	@GetMapping(value="/api/topics", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TopicBriefOutputDto> listTopics(){
		Category subcategory = new Category("Java", new Category("Programação"));
		Course course = new Course("Java e JSF", subcategory);
		
//		Topic topic = new Topic( 1l,"Problema com JSF", "Não ta funfando", new User("Fulano", "fulnao@gmail.com", "123456"), course);
		
//		List<Topic> topics = Arrays.asList(topic, topic, topic);
		
//		List<Topic> topics = topicRepository.list();
		
		List<Topic> topics = topicRepository.findAll();
		
		return TopicBriefOutputDto.listFromTopics(topics);
	}
}
