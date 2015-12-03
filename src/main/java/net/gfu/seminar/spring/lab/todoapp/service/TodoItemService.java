package net.gfu.seminar.spring.lab.todoapp.service;

import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;

import net.gfu.seminar.spring.lab.todoapp.dao.TodoItemDao;
import net.gfu.seminar.spring.lab.todoapp.domain.TodoItem;

@Service
public class TodoItemService {

	private final TodoItemDao dao;

	@Autowired
	public TodoItemService(TodoItemDao dao) {
		this.dao = dao;
	}

	public TodoItem save(TodoItem item) {
		if (item.getId() == null ){
			dao.insert(item);
			return item;
		} else {
			return dao.update(item);
		}
	}
	
	public void complete(TodoItem item) {
		// Optional.ofNullable(item). flatMap(i -> i.setDone(true));
		if (item != null) {
			item.setDone(true);
		}
	}
	
}
