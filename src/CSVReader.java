import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    String csvFile;
    String line = "";
    String csvSplitBy = ",";
    List<String> movies = new ArrayList<>();

    public List<String> getMovieList() {
        csvFile = FileChooser.chooseFile();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] movieWishList = line.split(csvSplitBy);
                if (!movieWishList[5].equals("Title")) {
                    movies.add(movieWishList[5]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
