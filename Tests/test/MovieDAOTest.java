package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import server.data.model.Movie;
import server.db.MovieDAO;

public class MovieDAOTest 
{

	@Test
	public void getMovieListTest() 
	{
		MovieDAO movieDAO = new MovieDAO();
		
		Movie movie1 = new Movie();
		movie1.setName("Test1");
		movie1.setGenre("TestGenre1");
		movie1.setYearReleased(1984);
		movie1.setRating("TestRating1");
		
		Movie movie2 = new Movie();
		movie2.setName("Test2");
		movie2.setGenre("TestGenre2");
		movie2.setYearReleased(1985);
		movie2.setRating("TestRating2");
		
		Movie movie3 = new Movie();
		movie3.setName("Test3");
		movie3.setGenre("TestGenre3");
		movie3.setYearReleased(1986);
		movie3.setRating("TestRating3");
		
		movieDAO.insert(movie1);
		movieDAO.insert(movie2);
		movieDAO.insert(movie3);
		
		LinkedList<Movie> testList = new LinkedList<Movie>();
		testList.add(movie1);
		testList.add(movie3);
		testList.add(movie2);
		
		
		LinkedList<Movie> DAOList = movieDAO.getMovieList();
		
		assertEquals(testList, DAOList);
	}

}
