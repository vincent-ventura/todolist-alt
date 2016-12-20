package fr.icdc.dei.todolist.commons.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Date oneWeekAgoDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		return cal.getTime();
	}
	
}
