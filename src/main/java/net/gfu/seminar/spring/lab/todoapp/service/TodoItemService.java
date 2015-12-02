package net.gfu.seminar.spring.lab.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.gfu.seminar.spring.lab.todoapp.dao.TodoItemDao;
import net.gfu.seminar.spring.lab.todoapp.domain.TodoItem;

@Service
public class TodoItemService {

	@Autowired
	TodoItemDao dao;
    	
	public TodoItem save(TodoItem item) {
		if (item.getId() == null ){
			dao.insert(item);
			return item;
		} else {
			return dao.update(item);
		}
	}
	
	public void complete(TodoItem item) {
		item.setDone(true);
	}
	
}
