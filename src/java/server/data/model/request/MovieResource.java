package server.data.model.request;

import java.util.LinkedList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import server.data.model.Movie;
import server.db.MovieDAO;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource 
{
	String defaultName;
	MovieDAO movieDAO = new MovieDAO();
	
	public MovieResource(String defaultName) 
	{
		this.defaultName = defaultName;
	}
	
	/**
	 * The getTime() method is a JSON GET that returns the time of day in 24h time
	 * @return
	 */
	@GET
	@Path("/timeOfDay")
	public String getTime() 
	{
		return Movie.getTime();
	}
	
	/**
	 * The createMovie method inserts a movie into the list via JSON POST
	 * @param m	Movie object
	 */
	@POST
	@Path("/movie/create")
	public void createMovie(Movie m) 
	{
		movieDAO.insert(m);
	}
	
	/**
	 * The updateMovie method updates an already existing entry in the list
	 * @param m Movie object
	 */
	@POST
	@Path("/movie/update")
	public void updateMovie(Movie m)
	{
		movieDAO.update(m);
	}
	
	/**
	 * The deleteMovie method deletes a movie from the list
	 * @param name The name of the movie
	 */
	@POST
	@Path("/movie/delete")
	public void deleteMovie(String name) 
	{
		movieDAO.delete(name);
	}
	
	/**
	 * The getMovieList method returns the entire list of movies
	 * @return the entire list of movies
	 */
	@GET
	@Path("/movie/list")
	public LinkedList getMovieList()
	{
		return movieDAO.getMovieList();
	}
}
