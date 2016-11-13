package fr.icdc.dei.todolist.service;

import static org.junit.Assert.assertTrue;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskServiceTest extends AbstractServiceTest {
	
	@Autowired
	private TaskService taskService;

	@Test
	public void testArchiveFinishedTasksSinceOneMonth() {
		assertTrue(CollectionUtils.isNotEmpty(taskService.archive()));
	}

}
