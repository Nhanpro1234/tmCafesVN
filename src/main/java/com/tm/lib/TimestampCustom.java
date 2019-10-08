package com.tm.lib;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TimestampCustom {
	public static String getDate() {
		Date myDate = new Date(System.currentTimeMillis());
    	return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(myDate);
	}
	
	
	public static String getTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	return String.valueOf(timestamp.getTime());
	}
	
	public static String convertTimeToDate(long value) {
		Timestamp timestamp = new Timestamp(value);
		Date myDate = new Date(timestamp.getTime());
    	return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(myDate);
	}
	
	public static long convertDateToTime(String value) {
		java.util.Date f = null;
		try {
			f = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(f == null) {
			return 0;
		}
		return f.getTime();
	}
}
