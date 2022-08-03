package net.guides.springboot.todomanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.net.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.core.env.Environment;

import net.guides.springboot.todomanagement.model.Todo;
import net.guides.springboot.todomanagement.service.ITodoService;

@Controller
public class TodoController {

	@Autowired
	private ITodoService todoService;

	@Autowired
	private Environment environment;

	public String getConfigMap() {
		return environment.getProperty("kubernetes.configmap");
	}

	public String getSecret() {
		return environment.getProperty("kubernetes.secret");
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("todos", todoService.getTodosByUser(name));
		// model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}

	@RequestMapping(value = "/devops-flow", method = RequestMethod.GET)
	public String showDevopsFlow(ModelMap model) {
		String ip = "127.1.1.1 - Hardcode";
		InetAddress inetAddress = null;
		try {
			inetAddress = InetAddress.getLocalHost();
			ip = inetAddress.getHostAddress();
		} catch (UnknownHostException e) {
			ip = "127.1.1.2 - Exception";
		}
		model.put("ipaddress", inetAddress);
		model.put("configmapValue", getConfigMap());
		model.put("secretsValue", getSecret());
		return "devops-flow";
	}

	private String getLoggedInUserName(ModelMap model) {
		return "admin";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo());
		return "todo";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam long id) {
		todoService.deleteTodo(id);
		// service.deleteTodo(id);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
		Todo todo = todoService.getTodoById(id).get();
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		todo.setUserName(getLoggedInUserName(model));
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		todo.setUserName(getLoggedInUserName(model));
		todoService.saveTodo(todo);
		return "redirect:/list-todos";
	}
}
