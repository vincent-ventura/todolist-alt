package fr.icdc.dei.todolist.service.enums;

public enum TaskStatusEnum {
	
	STARTED(1),
	FINISHED(2),
	ARCHIVED(3);
	
	private int value;
	
	private TaskStatusEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
