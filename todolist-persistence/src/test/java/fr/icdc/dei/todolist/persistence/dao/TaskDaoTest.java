package fr.icdc.dei.todolist.persistence.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.icdc.dei.todolist.persistence.entity.Task;

public class TaskDaoTest extends AsbtractDaoTest {

	private static final String TASK_NAME = "Hikingyo";

	@Autowired
	private TaskDao taskDao;
	
	private final static Task task = new Task();

	@Test
	public void testCreateTask() {
		task.setName("");
		assertNotNull(taskDao.save(task));
	}
	
	@Test
	public void testFindTaskByName( ){
		assertNotNull(taskDao.findByName(TASK_NAME));
	}
	
	@Test
	public void testFindTaskByNameExactly( ){
		assertEquals(TASK_NAME,taskDao.findByName(TASK_NAME).getName());
	}
}
