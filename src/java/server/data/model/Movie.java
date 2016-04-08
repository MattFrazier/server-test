package server.data.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie 
{
	
	private String name;
	private String genre;
	private int yearReleased;
	
	@Length(max = 3)
	private String rating;
	private String time;
	
	public Movie() 
	{
		
	}
	
	/**
	* Constructor, setting all fields of Movie
	* @param name	movie name
	* @param genre	movie genre
	* @param yearReleased	year the movie released
	* @param rating	movie rating
	**/
	public Movie(String name, String genre, int yearReleased, String rating) 
	{
		this.name = name;
		this.genre = genre;
		this.yearReleased = yearReleased;
		this.rating = rating;
	}
	
	@JsonProperty
	public String getName() 
	{
		return name;
	}
	
	@JsonProperty
	public void setName(String name)
	{
		this.name = name;
	}
	
	@JsonProperty
	public String getGenre() 
	{
		return genre;
	}
	
	@JsonProperty
	public void setGenre(String genre) 
	{
		this.genre = genre;
	}
	
	@JsonProperty
	public int getYearReleased()
	{
		return yearReleased;
	}
	
	@JsonProperty
	public void setYearReleased(int yearReleased)
	{
		this.yearReleased = yearReleased;
	}
	
	@JsonProperty
	public String getRating()
	{
		return rating;
	}
	
	@JsonProperty
	public void setRating(String rating) 
	{
		this.rating = rating;
	}
	
	/**
	 * The getTime method returns the current system time in a 24h format.
	 * @return
	 */
	@JsonProperty
	public static String getTime()
	{
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(cal.getTime()).toString();
		return time;
	}
}
