package serialization;

import mediaobjects.Book;
import mediaobjects.Media;
import mediaobjects.Movie;

import java.io.*;
import java.util.ArrayList;

public class CsvConverter {



    public static void convertToCSV (ArrayList<Media> list) {

        final String CSV_SEPARATOR = " ; ";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(".\\src\\serialization\\medias.csv"));

            for(Media m : list) {
                bufferedWriter.append(m.getClass().getSimpleName())
                        .append(CSV_SEPARATOR)
                        .append(m.getTitle())
                        .append(CSV_SEPARATOR)
                        .append(m.getGenre())
                        .append(CSV_SEPARATOR);

                if (m.getClass() == Book.class) {
                    bufferedWriter.append(((Book) m).getAuthor())
                            .append(CSV_SEPARATOR)
                            .append(((Book) m).getPublicationDate())
                            .append(CSV_SEPARATOR)
                            .append(((Book) m).getPages());

                }

                if (m.getClass() == Movie.class) {
                    bufferedWriter.append(((Movie) m).getDirector())
                            .append(CSV_SEPARATOR)
                            .append(((Movie) m).getReleaseDate())
                            .append(CSV_SEPARATOR)
                            .append(((Movie) m).getRunningTime());

                }
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList convertFromCSV(File csv) {

        ArrayList<Media> medias = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csv.getPath()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(" ; ");
                if (values[0].equals("Book")) {
                    medias.add(new Book(values[1], values[2], values[3], values[4], values[5]));
                }
                if (values[0].equals("Movie")) {
                    medias.add(new Movie(values[1], values[2], values[3], values[4], values[5]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return medias;
    }


}

