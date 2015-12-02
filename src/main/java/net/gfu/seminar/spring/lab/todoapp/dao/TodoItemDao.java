package net.gfu.seminar.spring.lab.todoapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.gfu.seminar.spring.lab.todoapp.domain.TodoItem;

@Component
@Transactional
public class TodoItemDao {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(TodoItem item) {
		em.persist(item);
	}
	
	public TodoItem update(TodoItem item) {
		return em.merge(item);
	}
	
	public TodoItem findById(Integer id) {
		return em.find(TodoItem.class, id);
	}
	
}
