package net.gfu.seminar.spring.lab.todoapp.repositories;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.gfu.seminar.spring.lab.todoapp.TodoAppConfig;
import net.gfu.seminar.spring.lab.todoapp.domain.TodoItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TodoAppConfig.class})
@ActiveProfiles({"test"})
public class TodoItemRepositoryTest {

	@Autowired
	TodoItemRepository repository;
	
	@Test
	public void testThatSavedItemIsFoundById() {
		TodoItem item = new TodoItem("foo", "bar");
		repository.save(item);
		System.out.println(item.getId());
		TodoItem savedItem = repository.findOne(item.getId());
		assertThat(savedItem).isNotNull();
		assertThat(savedItem.getId()).isEqualTo(item.getId());
	}

	@Test
	public void testThatSavedItemIsFoundByTopic() {
		TodoItem item = new TodoItem("foo", "bar");
		repository.save(item);
		System.out.println(item.getId());
		TodoItem savedItem = repository.findByTopic("foo").get(0);
		assertThat(savedItem).isNotNull();
	}

}
