package br.com.alura.forum.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.AnswerDto;
import br.com.alura.forum.controller.dto.input.AnswerInputDto;
import br.com.alura.forum.controller.repository.TopicRepository;
import br.com.alura.forum.model.Answer;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic_domain.Topic;
import br.com.alura.forum.service.NewReplyProcessorService;

@RestController
public class AnswerController {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private NewReplyProcessorService newReplyProcessorService;

	@PostMapping(value="/api/topics/{topicId}/answer", consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAnswer(@PathVariable("topicId") Long topicId, @RequestBody AnswerInputDto inputDto, @AuthenticationPrincipal User loggerUser, UriComponentsBuilder uriBuilder){
		
		Optional<Topic> topic = topicRepository.findById(topicId);
		
		Answer answer = new Answer(inputDto.getContent(), topic.get(), loggerUser);
		
		//answerRepository.save(answer);
		
		this.newReplyProcessorService.execute(answer);
		
		URI path = uriBuilder.path("/api/topics/{topicId}/answer/{answer}")
				.buildAndExpand(topicId, answer.getId())
				.toUri();
		
		AnswerDto outputDto = new AnswerDto(answer); 
		
		return ResponseEntity.created(path).body(outputDto);
	}
}
