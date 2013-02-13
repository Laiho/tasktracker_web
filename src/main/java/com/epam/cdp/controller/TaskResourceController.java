package com.epam.cdp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.cdp.tasktracker.facade.dao.TaskResourceFacade;
import com.epam.cdp.tasktracker.facade.dto.model.TaskDTO;

@Controller
@RequestMapping(value="/tasks")
public class TaskResourceController {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskResourceController.class);
	
	@Autowired
	private TaskResourceFacade taskResourceFacade;
	
	@RequestMapping(value = "/{id}/", method = RequestMethod.GET)
	@ResponseBody
	public TaskDTO getByIdTask(@PathVariable("id") final String id) {
		logger.info("Getting task by id: " + id);
		return taskResourceFacade.getTaskbyId(Long.parseLong(id));
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<TaskDTO> getTasks() {
		logger.info("Getting all tasks");
		return taskResourceFacade.getAllTasks();
	}
	
	@RequestMapping(value = "/{id}/", method = RequestMethod.POST)
	@ResponseBody
	public TaskDTO postGetTask(@PathVariable("id") final String id) {
		logger.info("Get task by id across POST method. Id: " + id);
		return taskResourceFacade.getTaskbyId(Long.parseLong(id));
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void createTasks(@RequestBody TaskDTO newTask) {
		logger.info("Creating task");
		taskResourceFacade.createTask(newTask);
	}
	
	@RequestMapping(value = "/{id}/", method = RequestMethod.DELETE)
	public void removeByIdTasks(@PathVariable("id") final String id) {
		logger.info("Remove task by Id");
		taskResourceFacade.removeTaskById(Long.parseLong(id));
	}
	
	@RequestMapping(value = "/{id}/", method = RequestMethod.PUT)
	public void updateTasks(@PathVariable("id") final String id, @RequestBody TaskDTO task) {
		logger.info("Update task by id: " + id);
		taskResourceFacade.updateTaskById(Long.parseLong(id), task);
	}
	
}
