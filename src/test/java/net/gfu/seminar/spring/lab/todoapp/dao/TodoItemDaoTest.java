package net.gfu.seminar.spring.lab.todoapp.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.gfu.seminar.spring.lab.todoapp.TodoAppConfig;
import net.gfu.seminar.spring.lab.todoapp.domain.TodoItem;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TodoAppConfig.class})
public class TodoItemDaoTest {

	@Autowired
	TodoItemDao dao;
	
	@Test
	public void testThatSavedItemIsFoundById() {
		TodoItem item = new TodoItem("foo", "bar");
		dao.insert(item);
		System.out.println(item.getId());
		TodoItem savedItem = dao.findById(item.getId());
		assertThat(savedItem).isNotNull();
		assertThat(savedItem.getId()).isEqualTo(item.getId());
	}

	
}
