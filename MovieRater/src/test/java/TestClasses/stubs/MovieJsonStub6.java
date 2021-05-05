package TestClasses.stubs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import MovieClasses.MovieDataLayer;

public class MovieJsonStub6 extends MovieDataLayer{
	@Override
	public String getJsonResponse(String movieName) throws IOException{
		return new String(Files.readAllBytes(Paths.get("src/test/resources/HarryPotter6.json")));
	}

}
