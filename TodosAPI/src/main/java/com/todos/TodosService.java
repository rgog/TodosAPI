package com.todos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodosService {
	
	private static List<Todos> todos = new ArrayList<Todos>();
	
	public List<Todos> getAllTodos(){
		return todos;
    }
	public List<Todos> getAllTodosDelayed(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return todos;
    }
	public Todos addTodo(Todos todo) {
		todos.add(todo);
		return todo;
	}
	public Todos updateTodo(String id) {
		for(Todos todo:todos){
			if(todo.uniqueID.trim().equals(id.trim())) {
				todo.setIsCompleted(true);
				return todo;
			}
		}
		return null;
	}
	public Todos deleteTodo(String id) {
		Todos removedTodo;
		for(Todos todo:todos){
			if(todo.uniqueID.trim().equals(id.trim())) {
				removedTodo = todo;
				todos.remove(todo);
				return removedTodo;
			}
		}
		return null;
//		todos.removeIf(todo->todo.uniqueID.equals(id));
	}
	
}
