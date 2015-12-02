package net.gfu.seminar.spring.lab.todoapp;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.gfu.seminar.spring.lab.todoapp.dao.TodoItemDao;
import net.gfu.seminar.spring.lab.todoapp.domain.TodoItem;

public class TodoMain {

	public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(TodoAppConfig.class);
        try {
        	TodoItemDao dao = context.getBean(TodoItemDao.class);
        	dao.insert(new TodoItem("foo", "bar"));
        } finally {
        	context.close();
        }
	}
}
