package MovieClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class MovieLogicLayer extends Task{
	
	
	private MovieDataLayer mdl;
	
	public MovieLogicLayer(MovieDataLayer mdl){
		this.mdl = mdl;
	}
	
	
	
/*public String getMovieName(String movieName) throws IOException{
		
		//try {
		String json = mdl.getJsonResponse(movieName);
		JSONObject jsonResponse = new JSONObject(json);
		String title = jsonResponse.getString("title");
		
		if(title.isEmpty()) {
			return null;
		}
		return title;
		/*}catch(IOException e) {
			return "error";
		}
	}*/
	
	
	public String getMovieRating(String movieName) throws IOException{
		
		//try {
			double rating;
			String title;
			String json = mdl.getJsonResponse(movieName);
			JSONObject jsonResponse = new JSONObject(json);
			if(jsonResponse.has("message")) {
				return "Film does not exist.";
			}else {
				
				title = jsonResponse.getString("title").replace('\u00A0',' ').trim();	
				String ratingS;
					if(jsonResponse.getString("rating") == "") {
						return "rating missing";
					}	else {
							ratingS = jsonResponse.getString("rating");
							rating = Double.parseDouble(ratingS);
				}
			}
			
			
			
			/*if(rating == 10)
				return jsonResponse.getString("title") + "is an Awesome film";
			else if(rating < 10)
				return jsonResponse.getString("title") + "is a Good film";
			else if(rating < 7)
				return jsonResponse.getString("title") + "is a Decent film";
			else if(rating < 4)
				return jsonResponse.getString("title") + "is a Bad film";
			else
				return "error";*/
			
			
			if(rating < 0 || rating > 10)
				return "Movie not found. Please try again";
			else if(rating < 4)
				return title + " is a Bad film";
			else if(rating < 7)
				return title + " is a Decent film";
			else if(rating < 9)
				return title + " is a Good film";
			else
				return title + " is an Awesome film";
			
	}



	
	String temp;
	@Override
	public boolean configure(List<String> movies) {
		// TODO Auto-generated method stub
		try {
			temp = getMovieRating(movies.get(0));
			
			if(!temp.equals("Film does not exist.")) {
				if(!temp.equals("rating missing")) {
					return true;
				}else {
				return false;
				}
			}else {
			return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}



	@Override
	public String run() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		//enter movie name
		list.add("Pacific Rim");
		if(configure(list)) {
			return temp;
		}else
		return "Film does not exist.";
	}
	
	
	
	
}
