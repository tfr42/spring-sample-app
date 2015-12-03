package net.gfu.seminar.spring.lab.todoapp.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import net.gfu.seminar.spring.lab.todoapp.dao.TodoItemDao;
import net.gfu.seminar.spring.lab.todoapp.domain.TodoItem;

public class TodoItemServiceTest {

	@Test
	public void testCompletedWorksAsExpected() {
		TodoItem todoItem = new TodoItem("foo", "bar");
		assertThat(todoItem.isDone()).isFalse();
		TodoItemDao dao = Mockito.mock(TodoItemDao.class);
		new TodoItemService(dao).complete(todoItem);
		assertThat(todoItem.isDone()).isTrue();
	}
	
	@Test
	public void testCompletedDealWithNulls() {
		TodoItemDao dao = Mockito.mock(TodoItemDao.class);
		new TodoItemService(dao).complete(null);
	}
	
	@Test
	public void testSaveNewItemWorksAsExpected() {
		TodoItemDao dao = Mockito.mock(TodoItemDao.class);
		TodoItem todoItem = new TodoItem("foo", "bar");
		new TodoItemService(dao).save(todoItem);
		verify(dao).insert(todoItem);
		verify(dao, never()).update(todoItem);
	}
		

}
