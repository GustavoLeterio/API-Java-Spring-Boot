package br.com.gustavoleterio.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gustavoleterio.forum.controller.form.TopicForm;
import br.com.gustavoleterio.forum.dto.TopicDto;
import br.com.gustavoleterio.forum.dto.UpdateTopicForm;
import br.com.gustavoleterio.forum.model.Topic;
import br.com.gustavoleterio.forum.repository.CourseRepository;
import br.com.gustavoleterio.forum.repository.TopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topics")
public class TopicsController {

	@Autowired
	private TopicRepository topicRepo;

	@Autowired
	private CourseRepository courseRepo;

	@GetMapping
	public List<TopicDto> list(String courseName) {

		if (courseName == null) {
			return TopicDto.convert(topicRepo.findAll());
		}
		return TopicDto.convert(topicRepo.findByCourse_Name(courseName));
	}

	@PostMapping
	public ResponseEntity<TopicDto> register(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
		Topic topic = form.toTopic(courseRepo);
		topic = topicRepo.save(topic);

		URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicDto(topic));
	}

	@GetMapping("/{id}")
	public ResponseEntity<TopicDto> detail(@PathVariable Long id) {
		Optional<Topic> topic = topicRepo.findById(id);
		if (topic.isPresent())
			return ResponseEntity.ok(new TopicDto(topicRepo.findById(id).get()));
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional

	public ResponseEntity<TopicDto> update(@PathVariable Long id, @RequestBody @Valid UpdateTopicForm form) {
		Optional<Topic> topic = topicRepo.findById(id);
		if (topic.isPresent())
			return ResponseEntity.ok(new TopicDto(form.update(id, topicRepo)));
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Topic> topic = topicRepo.findById(id);
		if (topic.isPresent()) {
			topicRepo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
