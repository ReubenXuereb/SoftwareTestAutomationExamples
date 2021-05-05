package TestClasses.stubs;

import java.io.IOException;

import MovieClasses.MovieDataLayer;

public class FailMovieStub extends MovieDataLayer {
	
	@Override
	public String getJsonResponse(String movieName) throws IOException{
		throw new IOException("Stub - API Failure");
	}

}
