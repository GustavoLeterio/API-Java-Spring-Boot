package br.com.gustavoleterio.forum.controller.form;

import br.com.gustavoleterio.forum.model.Topic;
import br.com.gustavoleterio.forum.repository.CourseRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TopicForm {

	@NotNull @NotEmpty
	private String title;
	@NotNull @NotEmpty
	private String message;
	@NotNull @NotEmpty
	private String courseName;

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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public static Topic convert(TopicForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	public Topic toTopic(CourseRepository courseRepository) {
		return new Topic(title, message, courseRepository.findByName(courseName));
	}
}
