package com.cybersoft.queue;

public class Task {

	private int id;
	private String nameTask;
	private int priority;

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Task() {

	}

	public Task(int id, String nameTask) {

		this.id = id;
		this.nameTask = nameTask;
	}

	public Task(int id, String nameTask, int priority) {

		this.id = id;
		this.nameTask = nameTask;
		this.priority = priority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameTask() {
		return nameTask;
	}

	public void setNameTask(String nameTask) {
		this.nameTask = nameTask;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", nameTask=" + nameTask + ", priority=" + priority + "]";
	}



}
