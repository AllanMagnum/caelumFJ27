package br.com.alura.forum.controller.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic_domain.Topic;



public interface TopicRepository extends JpaRepository<Topic, Long>, JpaSpecificationExecutor<Topic>{
	
	@Query("select t from Topic t")
	List<Topic> list();
	
	List<Topic> findAll();

	@Query("select t from Topic t Join Fetch t.course c where c.subcategory.category.name = :categoryName")
	List<Topic> findAllCategory(@Param(value = "categoryName") String categoryName);

	List<Topic> findByOwnerAndCreationInstantAfterOrderByCreationInstantAsc(User loggedUser, Instant oneHourAgo);
	
}