package br.com.alura.forum.controller.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.topic_domain.Topic;

public interface TopicRepository extends Repository<Topic, Long>, JpaSpecificationExecutor<Topic>{
	
	@Query("select t from Topic t")
	List<Topic> list();
	
	List<Topic> findAll();

	@Query("select t from Topic t Join Fetch t.course c where c.subcategory = :category")
	List<Topic> findAllCategory(Category category);
}
