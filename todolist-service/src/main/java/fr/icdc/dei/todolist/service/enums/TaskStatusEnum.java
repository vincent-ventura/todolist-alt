package fr.icdc.dei.todolist.service.enums;

public enum TaskStatusEnum {
	
	STARTED				(1, "INIT"),
	FINISHED			(2, "FINISHED"),
	ARCHIVED			(3, "ARCHIVED"), 
	DELEGATION_PENDING	(4, "DELEGATION_PENDING"),
	DELEGATED			(5, "DELEGATED");
	
	private int value;
	private String name;
	
	private TaskStatusEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

}
