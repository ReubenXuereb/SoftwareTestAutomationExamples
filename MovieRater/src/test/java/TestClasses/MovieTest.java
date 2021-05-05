package TestClasses;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import MovieClasses.MovieDataLayer;
import MovieClasses.MovieLogicLayer;
import TestClasses.stubs.FailMovieStub;
import TestClasses.stubs.MovieJsonStub;
import TestClasses.stubs.MovieJsonStub2;
import TestClasses.stubs.MovieJsonStub3;
import TestClasses.stubs.MovieJsonStub4;
import TestClasses.stubs.MovieJsonStub5;
import TestClasses.stubs.MovieJsonStub6;



public class MovieTest {
	
	@Test
	public void finalCorrectRunTest() {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		    assertEquals("Pacific Rim is a Decent film",mll.run(), "The proper output");
	}
	
	@Test
	public void trueCorrectConfigTest() {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		List<String> temp = new ArrayList<String>();
		temp.add("Kirk Cameron's Saving Christmas");
		 assertTrue(mll.configure(temp), "The proper output");
	}
	
	@Test
	public void falseCorrectConfigTest() {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		List<String> temp = new ArrayList<String>();
		temp.add("");
		 assertFalse(mll.configure(temp), "The proper output");
	}
	
	@Test
	public void falseCorrectConfig2Test() {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		List<String> temp = new ArrayList<String>();
		temp.add("a");
		 assertFalse(mll.configure(temp), "The proper output");
	}
	
	/*@Test
	public void titleMissinTest() throws IOException {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		assertEquals("title missing", mll.getMovieRating(" "), "...");
	}*/
	
	@Test
	public void badFilmTest() throws IOException {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		 assertEquals("Saving Christmas is a Bad film" ,mll.getMovieRating("Kirk Cameron's Saving Christmas"), "The proper output");
	}
	
	@Test
	public void decentFilmTest() throws IOException {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		 assertEquals("Pacific Rim is a Decent film" ,mll.getMovieRating("Pacific Rim"), "The proper output");
	}
	
	@Test
	public void goodFilmTest() throws IOException {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		 assertEquals("The Avengers is a Good film" ,mll.getMovieRating("Avengers"), "The proper output");
	}
	
	@Test
	public void awesomeFilmTest() throws IOException {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		 assertEquals("The Dark Knight is an Awesome film" ,mll.getMovieRating("The Dark Knight"), "The proper output");
	}
	
	@Test
	public void ratingMissingTest() throws IOException {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		assertEquals("rating missing", mll.getMovieRating("a"), "proper output");
	}
	
	@Test
	public void filmDoesNotExistTest() throws IOException {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		assertEquals("Film does not exist.", mll.getMovieRating(" "), "proper output");
	}
	
	@Test
	public void emptyJSONObject() throws IOException {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		assertEquals("rating missing", mll.getMovieRating(null), "proper output");
	}
	
	/*@Test
	public void titleMissingTest() throws IOException {
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		assertEquals("title missing", mll.getMovieRating("a"), "proper output");
	}*/
	
	
	
	//Stubs
	@Test
	public void failMovieStub() {
		FailMovieStub fs = new FailMovieStub();
		assertThrows(IOException.class, ()-> {fs.getJsonResponse("");});
	}
	
	@Test
	public void successMovieStub2() {
		MovieJsonStub2 mjs2 = new MovieJsonStub2();
		MovieLogicLayer mll = new MovieLogicLayer(mjs2);
		assertEquals("Movie not found. Please try again", mll.run(), "proper output");
	}
	
	@Test
	public void successMovieStub6() {
		MovieJsonStub6 mjs6 = new MovieJsonStub6();
		MovieLogicLayer mll = new MovieLogicLayer(mjs6);
		assertEquals("Movie not found. Please try again", mll.run(), "proper output");
	}
	
	@Test
	public void successAwesomeMovieStub() {
		MovieJsonStub mjs = new MovieJsonStub();
		MovieLogicLayer mll = new MovieLogicLayer(mjs);
		assertEquals("Harry Potter and the Sorcerer's Stone is an Awesome film", mll.run(), "proper output");
	}
	
	@Test
	public void successGoodMovieStub5() {
		MovieJsonStub5 mjs5 = new MovieJsonStub5();
		MovieLogicLayer mll = new MovieLogicLayer(mjs5);
		assertEquals("Harry Potter and the Sorcerer's Stone is a Good film", mll.run(), "proper output");
	}

	@Test
	public void successDecentMovieStub3() {
		MovieJsonStub3 mjs3 = new MovieJsonStub3();
		MovieLogicLayer mll = new MovieLogicLayer(mjs3);
		assertEquals("Harry Potter and the Sorcerer's Stone is a Decent film", mll.run(), "proper output");
	}
	
	@Test
	public void successBadMovieStub4() {
		MovieJsonStub4 mjs4 = new MovieJsonStub4();
		MovieLogicLayer mll = new MovieLogicLayer(mjs4);
		assertEquals("Harry Potter and the Sorcerer's Stone is a Bad film", mll.run(), "proper output");
	}
	
	
	
	
	
	/*@Test
	public void goodFilmTest() {
		List<String> params = Arrays.asList("Avengers");
		Task movieRater = new MovieTask();
		if (movieRater.configure(params) == true) {
			 String outcome = movieRater.run();
		    assertEquals("Avengers is a Good film",outcome, "The proper output");
		}
	}
	
	@Test
	public void decentFilmTest() {
		List<String> params = Arrays.asList("Pacific Rim");
		Task movieRater = new MovieTask();
		if (movieRater.configure(params) == true) {
			 String outcome = movieRater.run();
		    assertEquals("Pacific Rim is a Decent film",outcome, "The proper output");
		}
	}
	
	@Test
	public void badFilmTest() {
		List<String> params = Arrays.asList("Kirk Cameron's Saving Christmas");
		Task movieRater = new MovieTask();
		if (movieRater.configure(params) == true) {
			 String outcome = movieRater.run();
		    assertEquals("Kirk Cameron's Saving Christmas is a Bad film",outcome, "The proper output");
		}
	}
	
	/*@Test
	public void invalidMovieNameTest() {
		List<String> params = Arrays.asList("");
		Task movieRater = new MovieTask();
		if (movieRater.configure(params) == true) {;
		    assertEquals(params + " Is an invalid input, please write a movie",movieRater, "The proper output");
		}
	}
	
	
	
	@Test 
	public void noRatingTest() {
		List<String> params = Arrays.asList("a");
		Task movieRater = new MovieTask();
		if (movieRater.configure(params) == true) {
			 String outcome = movieRater.run();
		    assertEquals("Movie rating does not exist for a, please search for another movie.",outcome, "The proper output");
		}
	}
	
	@Test
	public void noTitleandRatingTest() {
		List<String> params = Arrays.asList("aasdfasdfasdfasdfasdfasdfasdfasdfasdfd");
		Task movieRater = new MovieTask();
		if (movieRater.configure(params) == true) {
			 String outcome = movieRater.run();
		    assertEquals("Movie not found.",outcome, "The proper output");
		}
	}
	
	@Test
	public void failStub() throws IOException {
		FailMovieStub failStub = new FailMovieStub();
		MovieLogicLayer mll = new MovieLogicLayer();
		assertEquals(-1, mll.getMovieRating("???"), "Stub will always through exception hence -1 should be returned.");
	}
	
	/*@Test 
	public void filteredJsonStubTest() {
		MovieJsonStub stub = new MovieJsonStub("src/test/resoruces/HarryPotter.json");
		MovieLogicLayer logic = new MovieLogicLayer(stub);
		assertEquals(10, logic.getMovieRating("???"), "using local file gorgonzola_filtered.json");
	}*/
	
	
}
