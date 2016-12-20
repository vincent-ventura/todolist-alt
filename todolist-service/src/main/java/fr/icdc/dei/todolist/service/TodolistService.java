package fr.icdc.dei.todolist.service;

import java.util.Date;
import java.util.List;

import fr.icdc.dei.todolist.persistence.entity.Task;
import fr.icdc.dei.todolist.persistence.entity.TaskStatus;

public interface TodolistService {
	
	List<Task> archiveTasks();
	
	Task affectTaskToUser(long idTask, long idUser);

	Task acceptDelegatedTask(long delegatedTaskId, long delegateUserId);

	List<Task> listTasks();
	
	Task addTask(String taskName, int statusId);

	Task addTask(String taskName, Date taskBeginDate, int statusId);

	List<TaskStatus> listTaskStatus();

	Task terminateTask(long taskId);

}
