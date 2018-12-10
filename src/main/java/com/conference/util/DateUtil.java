package com.conference.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static final DateFormat dateFormat = new SimpleDateFormat("hh:mm a");

	public static final Calendar lunchTime;

	public static final Calendar lunchFinishTime;

	public static final Calendar networkingStartTime;

	public static final Calendar eventFinishTime;

	static {

		// start lunchTime
		Calendar calendarLunch = Calendar.getInstance();
		calendarLunch.setTime(new Date());
		calendarLunch.set(Calendar.MILLISECOND, 0);
		calendarLunch.set(Calendar.SECOND, 0);
		calendarLunch.set(Calendar.MINUTE, 0);
		calendarLunch.set(Calendar.HOUR_OF_DAY, 12);

		lunchTime = calendarLunch;
		// end lunchTime

		// start lunchFinishTime
		Calendar calendarLunchFinish = Calendar.getInstance();
		calendarLunchFinish.setTime(new Date());
		calendarLunchFinish.set(Calendar.MILLISECOND, 0);
		calendarLunchFinish.set(Calendar.SECOND, 0);
		calendarLunchFinish.set(Calendar.MINUTE, 0);
		calendarLunchFinish.set(Calendar.HOUR_OF_DAY, 13);

		lunchFinishTime = calendarLunchFinish;
		// end lunchFinishTime

		// start networkingStartTime
		Calendar calendarNetworkingStartTime = Calendar.getInstance();
		calendarNetworkingStartTime.setTime(new Date());
		calendarNetworkingStartTime.set(Calendar.MILLISECOND, 0);
		calendarNetworkingStartTime.set(Calendar.SECOND, 0);
		calendarNetworkingStartTime.set(Calendar.MINUTE, 0);
		calendarNetworkingStartTime.set(Calendar.HOUR_OF_DAY, 16);

		networkingStartTime = calendarNetworkingStartTime;
		// end networkingStartTime

		// start eventFinishTime
		Calendar calendarEventFinishTime = Calendar.getInstance();
		calendarEventFinishTime.setTime(new Date());
		calendarEventFinishTime.set(Calendar.MILLISECOND, 0);
		calendarEventFinishTime.set(Calendar.SECOND, 0);
		calendarEventFinishTime.set(Calendar.MINUTE, 0);
		calendarEventFinishTime.set(Calendar.HOUR_OF_DAY, 17);

		eventFinishTime = calendarEventFinishTime;
		// end eventFinishTime

	}

	public static Calendar getStartTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 9);

		return calendar;
	}

	public static Calendar getLunchFinishTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 13);

		return calendar;
	}

	public static Calendar removeMinute(Calendar calendar, int minute) {
		calendar.add(Calendar.MINUTE, -minute);
		return calendar;
	}

	/**
	 * if return value == 1 --> canBeAdded = true if return value == 0 -->
	 * canBeAdded = true and session Full if return value == -1 --> canBeAdded =
	 * false
	 */
	public static int canBeAdded(Calendar calendar, int minute) {
		int canBeAdded;

		boolean beforeLunch = false;
		if (calendar.compareTo(lunchTime) < 0) {
			beforeLunch = true;
		}

		if (beforeLunch) {
			calendar.add(Calendar.MINUTE, minute);
			if (calendar.compareTo(lunchTime) < 0) {
				canBeAdded = 1;
			} else if (calendar.compareTo(lunchTime) == 0) {
				canBeAdded = 0;
			} else {
				removeMinute(calendar, minute);
				canBeAdded = -1;
			}
		} else {
			calendar.add(Calendar.MINUTE, minute);
			if (calendar.compareTo(eventFinishTime) < 0) {
				canBeAdded = 1;
			} else if (calendar.compareTo(eventFinishTime) == 0) {
				canBeAdded = 0;
			} else {
				removeMinute(calendar, minute);
				canBeAdded = -1;
			}
		}

		return canBeAdded;
	}

	public static boolean hasNetworkingEvent(Calendar calendar) {
		boolean hasNetworkingEvent = false;

		if (calendar.compareTo(networkingStartTime) >= 0) {
			hasNetworkingEvent = true;
		}

		return hasNetworkingEvent;
	}

	public static String formatTime(Calendar calendar) {
		return dateFormat.format(calendar.getTime());
	}

}
