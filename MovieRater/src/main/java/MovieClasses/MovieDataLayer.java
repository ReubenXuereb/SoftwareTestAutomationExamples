package MovieClasses;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieDataLayer {
	
	public String getJsonResponse(String movieName) throws IOException{
		
		
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
			.url("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/film/" + movieName)
			.get()
			.addHeader("x-rapidapi-key", "3a18fbe587msh2a99c5a49ed3ad8p1098ffjsnb9a6d962ace6")
			.addHeader("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com")
			.build();

		Response response = client.newCall(request).execute();
		
		return response.body().string();
	}
	
	

}
