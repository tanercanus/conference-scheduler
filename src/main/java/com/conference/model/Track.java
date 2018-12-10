package com.conference.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.conference.util.DateUtil;

public class Track {
	List<Conference> trackConferences = new ArrayList<>();
	Calendar time = DateUtil.getStartTime();
	List<String> conferenceList = new ArrayList<>();
	int number;
	boolean isLunchTimeAdded = false;

	public List<Conference> getTrackConferences() {
		return trackConferences;
	}

	public void setTrackConferences(List<Conference> trackConferences) {
		this.trackConferences = trackConferences;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public List<String> getConferenceList() {
		return conferenceList;
	}

	public void setConferenceList(List<String> conferenceList) {
		this.conferenceList = conferenceList;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isLunchTimeAdded() {
		return isLunchTimeAdded;
	}

	public void setLunchTimeAdded(boolean isLunchTimeAdded) {
		this.isLunchTimeAdded = isLunchTimeAdded;
	}

}
