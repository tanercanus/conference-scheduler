package com.conference.util;

import java.util.ArrayList;
import java.util.List;

import com.conference.constant.ProjectConstant;
import com.conference.model.Conference;
import com.conference.model.Track;

public class MainUtil {

	public static List<ArrayList<Conference>> convertSubmitBeanToList(String postInput) {

		if (postInput == null || postInput.trim().length() == 0)
			return null;

		String[] postInputArray = postInput.split(ProjectConstant.COMMA_DELIMETER);

		List<ArrayList<Conference>> allConferences = new ArrayList<ArrayList<Conference>>();

		ArrayList<Conference> conferences = new ArrayList<>();
		ArrayList<Conference> lightningConferences = new ArrayList<>();

		if (postInputArray != null && postInputArray.length > 0) {
			for (int i = 0; i < postInputArray.length; i++) {
				String[] itemArray = postInputArray[i].split(ProjectConstant.CONFERENCE_DELIMETER);
				if (itemArray != null && itemArray[0] != null && itemArray[1] != null) {
					Conference conference = new Conference();
					conference.setName(itemArray[0].trim());
					conference.setTime(Integer.parseInt(itemArray[1]));
					if (conference.getTime() == 0) {

						lightningConferences.add(conference);
					} else {
						conferences.add(conference);
					}

				}
			}

		}

		allConferences.add(conferences);
		allConferences.add(lightningConferences);

		return allConferences;

	}

	public static List<Track> scheduleConferences(List<ArrayList<Conference>> allConferences) {

		List<Track> tracks = new ArrayList<>();

		boolean isScheduleAllConf = false;

		while (!isScheduleAllConf) {
			Track track = new Track();

			// Before lunch and after lunch
			for (int i = 0; i < 2; i++) {

				isScheduleAllConf = true;
				if (i == 1) {
					track.setTime(DateUtil.getLunchFinishTime());
				}

				ArrayList<Conference> conferences = allConferences.get(0);
				ArrayList<Conference> lightningConferences = allConferences.get(1);

				boolean isSelectedScheduleFull = false;

				for (int j = 0; j < conferences.size(); j++) {
					Conference conference = conferences.get(j);

					// Added track before
					if (conference.isScheduled()) {
						continue;
					}

					// at least one element not used(scheduled)
					isScheduleAllConf = false;

					String formattedTime = DateUtil.formatTime(track.getTime());

					int canBeAdded = DateUtil.canBeAdded(track.getTime(), conference.getTime());
					if (canBeAdded == 1) {
						// add
						// Add Lunch Time
						addLunchTimeToTrack(track, i);

						addConferenceToTrack(conference, track);
						addConferenceListFormatted(track, true, formattedTime, conference.getName(),
								conference.getTime());

					} else if (canBeAdded == 0) {
						// add
						addConferenceToTrack(conference, track);
						addConferenceListFormatted(track, true, formattedTime, conference.getName(),
								conference.getTime());
						// Full
						isSelectedScheduleFull = true;
						break;
					}

				}

				// Add lightningConferences at the end
				if (!isSelectedScheduleFull) {
					for (int j = 0; j < lightningConferences.size(); j++) {
						Conference conference = lightningConferences.get(j);

						// Added track before
						if (conference.isScheduled()) {
							continue;
						}

						// at least one element not used(scheduled)
						isScheduleAllConf = false;

						String formattedTime = DateUtil.formatTime(track.getTime());

						// Added 5 minutes for lightningConference
						int canBeAdded = DateUtil.canBeAdded(track.getTime(), 5);
						if (canBeAdded == 1) {
							// add
							// Add Lunch Time
							addLunchTimeToTrack(track, i);

							addConferenceToTrack(conference, track);
							addConferenceListFormatted(track, false, formattedTime, conference.getName(), 0);
						} else if (canBeAdded == 0) {
							// add
							addConferenceToTrack(conference, track);
							addConferenceListFormatted(track, false, formattedTime, conference.getName(), 0);
							// Full
							break;
						}
					}
				}

				// If posible add neworking event
				addNetworkingEventToTrack(track, i);

				if (isScheduleAllConf)
					break;

			}

			if (track.getTrackConferences().size() > 0) {
				track.setNumber(tracks.size() + 1);
				tracks.add(track);
			}

		}

		return tracks;
	}

	private static void addLunchTimeToTrack(Track track, int i) {
		if (i == 1 && !track.isLunchTimeAdded()) {
			track.getConferenceList().add(DateUtil.formatTime(DateUtil.lunchTime) + ProjectConstant.LUNCH_STRING);
			track.setLunchTimeAdded(true);
		}
	}

	private static void addNetworkingEventToTrack(Track track, int i) {
		if (i == 1 && DateUtil.hasNetworkingEvent(track.getTime())) {
			track.getConferenceList()
					.add(DateUtil.formatTime(track.getTime()) + ProjectConstant.NETWORKING_EVENT_STRING);
		}
	}

	private static void addConferenceToTrack(Conference conference, Track track) {
		conference.setScheduled(true);
		track.getTrackConferences().add(conference);
	}

	private static void addConferenceListFormatted(Track track, boolean addMinStr, String time, String name,
			int conferenceMinutes) {
		if (addMinStr) {
			track.getConferenceList().add(time + " " + name + " " + conferenceMinutes + ProjectConstant.MIN_STRING);
		} else {
			track.getConferenceList().add(time + " " + name);
		}
	}

}
