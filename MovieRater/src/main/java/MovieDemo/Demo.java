package MovieDemo;

import java.io.IOException;
import MovieClasses.MovieDataLayer;
import MovieClasses.MovieLogicLayer;

public class Demo {
	public static void main(String[] args) throws IOException {
		/*List<String> params = Arrays.asList("The Dark Knight");
		Task movieRater = new MovieTask();
		if (movieRater.configure(params) == true) {
		    String outcome = movieRater.run();
		    System.out.println(outcome);
		}else {
			System.out.println(params + " Is an invalid input, please write a movie");
		}
	}*/
		MovieDataLayer mdl = new MovieDataLayer();
		MovieLogicLayer mll = new MovieLogicLayer(mdl);
		System.out.println(mll.run());
		
	}
}
