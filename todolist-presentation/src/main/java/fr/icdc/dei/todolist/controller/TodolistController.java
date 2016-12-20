package fr.icdc.dei.todolist.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.icdc.dei.todolist.commons.utils.DateUtils;
import fr.icdc.dei.todolist.service.TodolistService;
import fr.icdc.dei.todolist.service.enums.TaskStatusEnum;

@Controller
@RequestMapping("/")
public class TodolistController {
	
	private static final String TASKS_HTTP_ATTR = "tasks";
	private static final String STATUS_HTTP_ATTR = "status";
	private static final String ONE_WEEK_AGO_DATE_HTTP_ATTR = "oneWeekAgoDate";
	private static final String FINISHED_TASK_STATUS_NAME_HTTP_ATTR = "finishedTaskStatusName";
	private static final String FINISHED_TASK_STATUS_NAME = TaskStatusEnum.FINISHED.getName();
	
	@Autowired
	private TodolistService todolistService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView page = new ModelAndView("Home");
		page.addObject(ONE_WEEK_AGO_DATE_HTTP_ATTR, DateUtils.oneWeekAgoDate());
		page.addObject(FINISHED_TASK_STATUS_NAME_HTTP_ATTR, FINISHED_TASK_STATUS_NAME);
		page.addObject(TASKS_HTTP_ATTR, todolistService.listTasks());
		return page;
	}
	
	@RequestMapping(value = "create", method=RequestMethod.GET)
	public ModelAndView renderCreateTaskForm() {
		ModelAndView page = new ModelAndView("TaskForm");
		page.addObject(STATUS_HTTP_ATTR, todolistService.listTaskStatus());
		return page;
	}
	
	@RequestMapping(value = "create", method=RequestMethod.POST)
	public ModelAndView createTask(@RequestParam String taskName, @RequestParam Date taskBeginDate, @RequestParam("status") int statusId) {
		todolistService.addTask(taskName, taskBeginDate, statusId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "terminate/{taskId}", method=RequestMethod.GET)
	public ModelAndView terminateTask(@PathVariable int taskId) {
		todolistService.terminateTask(taskId);
		return new ModelAndView("redirect:/");
	}

}
