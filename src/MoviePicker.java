import java.util.List;
import java.util.Random;

public class MoviePicker {

    private static List<String> movies;
    private static String movie;

    public static void main(String[] args) { launch(); }

    private static void launch() {
        new GUI();
    }

    private static String getRandomMovie(List<String> movies) {
        int random = new Random().nextInt(movies.size());
        return movies.get(random);
    }

    public String getMovie() {
        movies = new CSVReader().getMovieList();
        movie = getRandomMovie(movies);
        return movie;
    }
}