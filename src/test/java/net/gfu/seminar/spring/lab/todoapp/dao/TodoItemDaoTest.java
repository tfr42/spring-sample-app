package net.gfu.seminar.spring.lab.todoapp.dao;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.gfu.seminar.spring.lab.todoapp.TodoAppConfig;
import net.gfu.seminar.spring.lab.todoapp.domain.TodoItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TodoAppConfig.class})
@ActiveProfiles({"test"})
public class TodoItemDaoTest {

	@Autowired
	TodoItemDao dao;
	
	@Autowired
	private Environment env;

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
