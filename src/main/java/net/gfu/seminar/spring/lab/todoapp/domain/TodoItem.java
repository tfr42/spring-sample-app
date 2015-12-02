package net.gfu.seminar.spring.lab.todoapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="todo_seq", sequenceName="todo_seq", allocationSize=1)
public class TodoItem {

	@Id
	@GeneratedValue(generator = "todo_seq")
	private Integer id;
	private String topic;
	@Column(length=1024)
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	private boolean done;
	

	public TodoItem() {
	}
	
	public TodoItem(String topic, String description) {
		this.topic = topic;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	
}
