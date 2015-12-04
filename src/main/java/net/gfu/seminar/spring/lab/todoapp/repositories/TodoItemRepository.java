/**
 * 
 */
package net.gfu.seminar.spring.lab.todoapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.gfu.seminar.spring.lab.todoapp.domain.TodoItem;

/**
 * @author Rene Gielen
 *
 */
public interface TodoItemRepository extends CrudRepository<TodoItem, Integer>{
	
	List<TodoItem> findByTopic(String topic);

}
