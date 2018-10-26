package br.com.alura.forum.controller;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
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
import br.com.alura.forum.controller.dto.output.TopicDashBoardOutputDto;
import br.com.alura.forum.controller.repository.CategoryRepository;
import br.com.alura.forum.controller.repository.TopicRepository;
import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.topic_domain.Topic;


@RestController
public class TopicController {
	
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
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
	
	@GetMapping(value="/api/topics/dashboard", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TopicDashBoardOutputDto> listTopicsDashBoard(){
		 		
		return this.findAllCategory();
	}
	
	private List<TopicDashBoardOutputDto> findAllCategory(){ 
				
		List<TopicDashBoardOutputDto> list = new ArrayList<>();
		
		List<Category> allCategory = categoryRepository.findAll();
		
		for (Category category : allCategory) {
			List<Topic> topics = topicRepository.findAllCategory(category.getName());
			
			TopicDashBoardOutputDto topicDashBoardOutputDto = new TopicDashBoardOutputDto();
			
			topicDashBoardOutputDto.setCategoryName(category.getName());
			
			topicDashBoardOutputDto.setAllTopics((long) topics.size());			
			
			long unansweredTopics = 0;
			long lastWeekTopics = 0;
			
			for (Topic topic : topics) {
				topicDashBoardOutputDto.getSubcategories().add(topic.getCourse().getSubcategory().getName());
				
				if( topic.getAnswers().isEmpty() )
					unansweredTopics++;
				
				
				if( isLastWeek( topic.getCreationInstant() ) )
					lastWeekTopics++;
			}		
			
			topicDashBoardOutputDto.setUnansweredTopics(unansweredTopics);
			topicDashBoardOutputDto.setLastWeekTopics(lastWeekTopics);
			
			list.add(topicDashBoardOutputDto);
		}
		
		return list;
	}
	
	private boolean isLastWeek(Instant createInstant) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(createInstant, ZoneOffset.UTC);
		
		int valor = 7 - localDateTime.getDayOfWeek().getValue();
		
		return false;
	}

}