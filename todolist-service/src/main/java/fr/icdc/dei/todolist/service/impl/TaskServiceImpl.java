package fr.icdc.dei.todolist.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.icdc.dei.todolist.persistence.dao.TaskDao;
import fr.icdc.dei.todolist.persistence.entity.Task;
import fr.icdc.dei.todolist.persistence.entity.TaskStatus;
import fr.icdc.dei.todolist.service.TaskService;
import fr.icdc.dei.todolist.service.enums.TaskStatusEnum;

@Service("TaskService")
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;

	@Override
	public List<Task> archive() {
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.MONTH, 1);
		List<Task> tasksToArchive =  taskDao.findAllByClosedDateBefore(cal.getTime());
		for(Task task:tasksToArchive){
			task.setStatus(new TaskStatus(TaskStatusEnum.ARCHIVED.getValue()));
			taskDao.save(task);
		}
		return tasksToArchive;
	}

}
