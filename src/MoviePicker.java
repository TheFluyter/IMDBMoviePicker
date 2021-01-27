import java.util.List;
import java.util.Random;

public class MoviePicker {

    private static List<String> movies;
    private static String movie;

    public static void main(String[] args) { new GUI(); }

    // Get IMDB movie list through CSV reader and pick a random movie
    public static String getMovie() {
        movies = new CSVReader().getMovieList();
        int random = new Random().nextInt(movies.size());
        movie = movies.get(random);
        return movie;
    }

    // Pick a different movie, but don't change the movie list. Available after getMovie method.
    public static String getDifferentMovie() {
        int random = new Random().nextInt(movies.size());
        String newMovie = movies.get(random);

        if (!newMovie.equals(movie)) {
            movie = newMovie;
            return newMovie;

        } else if (random + 1 < movies.size()) {
            movie = movies.get(random + 1);
            return movie;

        } else if (random - 1 != 0) {
            movie = movies.get(random - 1);
            return movie;
        }
        return newMovie;
    }
}