package br.com.alura.forum.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.input.TopicSearchInputDt0;
import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto;
import br.com.alura.forum.controller.repository.TopicRepository;
import br.com.alura.forum.model.topic_domain.Topic;


@RestController
public class TopicController {
	
	
	@Autowired
	private TopicRepository topicRepository;
	
	@GetMapping(value="/api/topics", produces=MediaType.APPLICATION_JSON_VALUE)
	public Page<TopicBriefOutputDto> listTopics(TopicSearchInputDt0 topicSearchBuild, @PageableDefault(sort="creationInstant", direction=Sort.Direction.DESC) Pageable pageRequest){
		
//		Category subcategory = new Category("Java", new Category("Programação"));
//		Course course = new Course("Java e JSF", subcategory);
		
//		Topic topic = new Topic( 1l,"Problema com JSF", "Não ta funfando", new User("Fulano", "fulnao@gmail.com", "123456"), course);
		
//		List<Topic> topics = Arrays.asList(topic, topic, topic);
		
//		List<Topic> topics = topicRepository.list();
		
//		List<Topic> topics = topicRepository.findAll();
		
		Specification<Topic> topicSearchSpecification = topicSearchBuild.build();
		Page<Topic> topics = topicRepository.findAll(topicSearchSpecification, pageRequest);
		
		return TopicBriefOutputDto.listFromTopics(topics);
	}
}
