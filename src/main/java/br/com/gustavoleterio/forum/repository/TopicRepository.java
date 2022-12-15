package br.com.gustavoleterio.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavoleterio.forum.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

	List<Topic> findByCourse_Name(String name);
}
