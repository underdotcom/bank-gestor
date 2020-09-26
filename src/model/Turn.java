package model;

public class Turn {

	//Priority are sort with level 0,1,2,3. Being the last position the most priority
	public static final String[] priority = {"common", "old person", "pregnant woman", "disabled person"};
	
	private String user;
	private String cc;
	private int priorityValue;
	
	public Turn(String user, String cc, int priorityValue) {
		this.user = user;
		this.cc = cc;
		this.priorityValue = priorityValue;
	}

	public String getUser() {
		return user;
	}

	public String getId() {
		return cc;
	}

	public int getPriorityValue() {
		return priorityValue;
	}
}
