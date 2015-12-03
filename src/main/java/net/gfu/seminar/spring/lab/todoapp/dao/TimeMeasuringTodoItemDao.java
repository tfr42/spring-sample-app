package net.gfu.seminar.spring.lab.todoapp.dao;

import net.gfu.seminar.spring.lab.todoapp.domain.TodoItem;

public class TimeMeasuringTodoItemDao extends TodoItemDao {

	@Override
	public TodoItem findById(Integer id) {
		long start = System.currentTimeMillis();
		TodoItem findById = super.findById(id);
		long end = System.currentTimeMillis();
		System.out.println("Took time in millies: " + (end-start));
		return findById;
	}
}
