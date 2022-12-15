package br.com.gustavoleterio.forum.dto;

import br.com.gustavoleterio.forum.model.Topic;
import br.com.gustavoleterio.forum.repository.TopicRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UpdateTopicForm {
	@NotNull @NotEmpty
	private String title;
	@NotNull @NotEmpty
	private String message;
	
	public UpdateTopicForm(String title, String message) {
		this.title = title;
		this.message = message;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Topic update(Long id, TopicRepository topicRepo) {
		Topic topic = topicRepo.findById(id).get();
		topic.setTitle(this.title);
		topic.setMessage(this.message);

		return topic;
		
	}
	
}
