package com.todos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodosController {
	private TodosService todosService;
	@Autowired
	public TodosController(TodosService todosService) {
		super();
		this.todosService = todosService;
	}
	@GetMapping("")
	public ResponseEntity<List<Todos>> getAllTodos(){
		return new ResponseEntity<List<Todos>>(this.todosService.getAllTodos(), HttpStatus.OK);
    }
	@GetMapping("/delayed")
	public ResponseEntity<List<Todos>> getAllTodosDelayed(){
		return new ResponseEntity<List<Todos>>(this.todosService.getAllTodosDelayed(), HttpStatus.OK);
    }
	@PostMapping("")
	public ResponseEntity<Todos> addTodo(@RequestBody Todos todo) {
		this.todosService.addTodo(todo);
		return new ResponseEntity<Todos>(todo, HttpStatus.CREATED);
	}
	@PutMapping("/complete/{id}")
	public ResponseEntity<Todos> updateTodo(@PathVariable String id){
		Todos todo = this.todosService.updateTodo(id);
		return new ResponseEntity<Todos>(todo, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Todos> deleteTodo(@PathVariable String id){
		return new ResponseEntity<Todos>(this.todosService.deleteTodo(id), HttpStatus.OK);
	}
}
