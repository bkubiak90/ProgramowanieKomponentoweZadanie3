package Main;

import MediaObjects.Book;
import MediaObjects.Media;
import MediaObjects.Movie;
import SortObjects.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Media[] medias = new Media[10];
        init(medias);
        start(medias);


    }

    public static void init(Media[] medias) {
        medias[0] = new Book("The Unknown Kimi Raikkonen", "Biography", "Kari Hotakainen", "2018", "336");
        medias[1] = new Book("The Green Mile", "Novel", "Stephen King", "1996", "416");
        medias[2] = new Book("The Alchemist", "Novel", "Paulo Coelho", "1988", "163");
        medias[3] = new Movie("Star Wars: Return of the Jedi", "Science fiction", "Richard Marquand", "1983", "132");
        medias[4] = new Movie("Green Book", "Biographical comedy-drama", "Peter Farrelly", "2018", "130");
        medias[5] = new Movie("The Hobbit: An Unexpected Journey", "Fantasy", "Peter Jackson", "2012", "169");
    }

    public static void start(Media[] medias) {
        Scanner scanner = new Scanner(System.in);
        int index = 6;
        boolean quit = false;

        do {
            System.out.println(
                            "\n" +
                            "========\n" +
                            "1.Add \n" +
                            "2.Print \n" +
                            "3.Sort \n" +
                            "4.Quit"
            );

            switch (scanner.nextInt()) {
                case 1:
                    if (index < medias.length) {
                    System.out.println(
                                    "1.Movie \n" +
                                    "2.Book"
                    );
                    int choice = scanner.nextInt();

                        if (choice == 1) {
                            scanner.nextLine();
                            System.out.print("Title: ");
                            String title = scanner.nextLine();
                            System.out.print("Director: ");
                            String director = scanner.nextLine();
                            System.out.print("Genre: ");
                            String genre = scanner.nextLine();
                            System.out.print("Running Time: ");
                            String length = scanner.nextLine();
                            System.out.print("Release Date: ");
                            String releaseDate = scanner.nextLine();
                            for (int i = 0; i < 10; i++) {
                                if (null == medias[i]) {
                                    medias[i] = new Movie(title, genre, director, releaseDate, length);
                                    i = 10;
                                    index++;
                                }
                            }
                        } else if (choice == 2) {
                            scanner.nextLine();
                            System.out.print("Title: ");
                            String title = scanner.nextLine();
                            System.out.print("Author: ");
                            String author = scanner.nextLine();
                            System.out.print("Genre: ");
                            String genre = scanner.nextLine();
                            System.out.print("Pages: ");
                            String pages = scanner.nextLine();
                            System.out.print("Publication Date: ");
                            String publicationDate = scanner.nextLine();
                            for (int i = 0; i < 10; i++) {
                                if (null == medias[i]) {
                                    medias[i] = new Book(title, genre, author, publicationDate, pages);
                                    i = 10;
                                    index++;
                                }
                            }
                        }
                    } else {
                            System.out.println("No space available to add new record");
                    }
                    break;
                case 2:
                    for (Media m : medias) {
                        if (null != m) {
                            System.out.println(m.toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println(
                                    "1.byTitle \n" +
                                    "2.byGenre \n" +
                                    "3.byAuthor \n" +
                                    "4.byReleaseDate \n" +
                                    "5.byLength"
                    );

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) {
                        Arrays.sort(medias, new SortByTitle());
                    } else if (choice == 2) {
                        Arrays.sort(medias, new SortByGenre());
                    } else if (choice == 3) {
                        Arrays.sort(medias, new SortByAuthor());
                    } else if (choice == 4) {
                        Arrays.sort(medias, new SortByRealeaseDate());
                    } else if (choice == 5) {
                        Arrays.sort(medias, new SortlByLenght());
                    }
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice, pick other");
                    break;
            }
        } while (!quit);
    }
}
