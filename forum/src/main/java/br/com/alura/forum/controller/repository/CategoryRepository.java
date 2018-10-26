package br.com.alura.forum.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.alura.forum.model.Category;

public interface CategoryRepository  extends Repository<Category, Long>{
	
	@Query("select t from Category t where t.category is null")
	List<Category> findAll();

}
