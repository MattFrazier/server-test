package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import server.data.model.Movie;

public class MovieTest 
{

	/**
	 * Test for getting the current time.
	 */
	@Test
	public void getTimeTest() 
	{
		Movie m = new Movie();
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(cal.getTime()).toString();
		assertEquals(m.getTime(), time);
	}

}
