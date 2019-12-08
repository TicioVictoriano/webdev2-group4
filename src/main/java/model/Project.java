package model;

public class Project { 
	private int id;
	private String name;
	private String completionDate;
	private String intendedDate;
	private String user_id;
	private int completed;
	private int status_id;
	private int modules_id;
	
	
	public Project(int id, String name, String completionDate, String intendedDate, String user_id, int completed,
			int status_id, int modules_id) {
		super();
		this.id = id;
		this.name = name;
		this.completionDate = completionDate;
		this.intendedDate = intendedDate;
		this.user_id = user_id;
		this.completed = completed;
		this.status_id = status_id;
		this.modules_id = modules_id;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}
	public String getIntendedDate() {
		return intendedDate;
	}
	public void setIntendedDate(String intendedDate) {
		this.intendedDate = intendedDate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public int getModules_id() {
		return modules_id;
	}
	public void setModules_id(int modules_id) {
		this.modules_id = modules_id;
	}
}
