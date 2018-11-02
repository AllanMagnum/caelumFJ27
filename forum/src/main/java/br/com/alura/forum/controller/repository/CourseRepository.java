package br.com.alura.forum.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.model.Course;


public interface CourseRepository extends JpaRepository<Course, Long>{
	
	Course findByName(String courseName);

}