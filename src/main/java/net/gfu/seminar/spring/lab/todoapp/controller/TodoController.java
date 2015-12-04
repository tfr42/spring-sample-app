package net.gfu.seminar.spring.lab.todoapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.gfu.seminar.spring.lab.todoapp.domain.TodoItem;
import net.gfu.seminar.spring.lab.todoapp.repositories.TodoItemRepository;

@Controller
@RequestMapping("todos")
public class TodoController {

	@Autowired
	TodoItemRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView todos() {
		return new ModelAndView("todos", "todoItems", repository.findAll());
	}
	
	@RequestMapping(value="new", method=RequestMethod.GET)
	public String showNew(Model model) {
		model.addAttribute("todo", new TodoItem());
		return "showTodo";
	}

	@RequestMapping(value="new", method=RequestMethod.POST)
	public String saveNew(TodoItem todo) {
		return save(todo);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public String save(TodoItem todo) {
		return "redirect:"+repository.save(todo).getId();
	}

	@RequestMapping(value="{id}", method=RequestMethod.GET) // /todos/1
	public String show(@PathVariable Integer id, Model model) {
		model.addAttribute("todo", repository.findOne(id));
		return "showTodo";
	}

}
