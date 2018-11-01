package br.com.alura.forum.controller.repository;

import org.springframework.stereotype.Repository;

import br.com.alura.forum.model.Course;

@Repository
public interface CourseRepository {
	
	Course findByName(String courseName);

}