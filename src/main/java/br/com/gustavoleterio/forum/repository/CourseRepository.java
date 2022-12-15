package br.com.gustavoleterio.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavoleterio.forum.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Course findByName(String courseName);
}
