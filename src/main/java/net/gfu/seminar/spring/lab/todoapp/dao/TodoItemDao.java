package net.gfu.seminar.spring.lab.todoapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.gfu.seminar.spring.lab.todoapp.domain.TodoItem;

@Component
@Transactional
public class TodoItemDao {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Als Kommentar in dieser Methode Pseudocode, der das Verhalten von @Transcational verdeutlicht  
	 */
	public void insert(TodoItem item) {
		// tx = lookup existing Transaction
		// if tx == null
		//  tx = new Transaction
		//  iAmCreator = true
		//  try {
		em.persist(item);
		//  } catch (Exception e) {
		//    tx.setRollbackOnly
		//    throw e
		//  } finally {
		//    if iAmCreator
		//         tx.close
		// }
	}
	
	public TodoItem update(TodoItem item) {
		return em.merge(item);
	}
	
	// So würde man eine von der Klassendefinition abweichende Transaktionsdefinition für die Methode machen
	// @Transactional(propagation = Propagation.REQUIRES_NEW)
	public TodoItem findById(Integer id) {
		return em.find(TodoItem.class, id);
	}
	
}
