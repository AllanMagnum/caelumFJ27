package br.com.alura.forum.validator;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.alura.forum.controller.repository.TopicRepository;
import br.com.alura.forum.model.PossibleSpam;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic_domain.Topic;

public class NewTopicCustomValidator implements Validator{

	private final TopicRepository topicRepository;
	private User loggedUser;
	
	public NewTopicCustomValidator(TopicRepository topicRepository, User loggedUser) {
		this.topicRepository = topicRepository;
		this.loggedUser = loggedUser;
	}
 
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors erros) {
		
		Instant oneHourAgo = Instant.now().minus(1, ChronoUnit.HOURS);
		
		List<Topic> topics = topicRepository.findByOwnerAndCreationInstantAfterOrderByCreationInstantAsc(loggedUser, oneHourAgo);
		
		PossibleSpam possibleSpam = new PossibleSpam(topics);
		
		if(possibleSpam.hasTopicLimitExceeded()){
			long minutesToNextTopic = possibleSpam.minutesToNextTopic(oneHourAgo);
			erros.reject("newTopicInputDto.limit.exceeded", new Object[]{minutesToNextTopic}, "O limite individual de novos tópicos por hora foi excedido");
		}
	}
	

}