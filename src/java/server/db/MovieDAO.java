package server.db;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import server.data.model.Movie;

public class MovieDAO
{

	//Commented lines below were going to be used if implemented with H2 Database
	
	/*@SqlUpdate("insert into movies (name, genre, yearReleased, rating) values (:name, :genre, :yearReleased, :rating)")
	void insert(@bind("name") String name, @Bind("genre") String genre, @Bind("yearReleased") int yearReleased, @Bind("rating") String rating);
	
	@SqlUpdate("update movies set (name = :name, genre = :genre, yearReleased = :yearReleased, rating = :rating) where name = :name")
	void update(@bind("name") String name, @Bind("genre") String genre, @Bind("yearReleased") int yearReleased, @Bind("rating") String rating);
	
	@SqlUpdate("delete from movies where name = :name")
	void delete(@bind("name") String name);*/
	
	private Map<String, Movie> movieMap = new HashMap<String, Movie>();
	
	/**
	 * Inserts new movie into the map
	 * @param m Movie object
	 */
	public void insert(Movie m) 
	{
		movieMap.put(m.getName(), m);
	}
	
	/**
	 * Deletes an entry from the map
	 * @param name Name of the movie to be deleted
	 */
	public void delete(String name) 
	{
		movieMap.remove(name);
	}
	
	/**
	 * Updates an entry in the map, uses name from movie object to perform the update
	 * @param m Movie object
	 */
	public void update(Movie m) 
	{
		movieMap.replace(m.getName(), m);
	}
	
	/**
	 * Returns the list of all movies in the map
	 * @return LinkedList of all movies in the list
	 */
	public LinkedList<Movie> getMovieList()
	{
		Set<String> keySet = movieMap.keySet();
		LinkedList<Movie> result = new LinkedList<Movie>();
		Iterator<String> i = keySet.iterator();
		
		while(i.hasNext()) 
		{
			String curr = i.next();
			result.add(movieMap.get(curr));
		}
		return result;
	}
	
}
