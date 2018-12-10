package com.conference.model;

public class Conference {
	String name;
	int time;
	boolean isScheduled = false;

	public Conference() {
		super();
	}

	public Conference(String name, int time, boolean isScheduled) {
		super();
		this.name = name;
		this.time = time;
		this.isScheduled = isScheduled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public boolean isScheduled() {
		return isScheduled;
	}

	public void setScheduled(boolean isScheduled) {
		this.isScheduled = isScheduled;
	}

}
