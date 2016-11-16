package fr.icdc.dei.todolist.service;

import java.util.List;

import fr.icdc.dei.todolist.persistence.entity.Task;

public interface TodolistService {
	
	List<Task> archiveTasks();
	
	Task affectTaskToUser(long idTask, long idUser);

	Task acceptDelegatedTask(long delegatedTaskId, long delegateUserId);

	List<Task> listTasks();

}
