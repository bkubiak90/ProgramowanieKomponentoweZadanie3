package main;

import mediaobjects.Book;
import mediaobjects.Media;
import mediaobjects.Movie;
import serialization.CsvConverter;
import serialization.XmlConverter;
import sortobjects.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Zadanie 4.2 - pkt 1, 2
        //   ZAPIS DO PLIKU TEKSTOWEGO
        File plik = new File(".\\src\\main\\plik.txt");
        String tekstDoZapisania = new String("Java is a class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.");

        try {
            if (!plik.exists()) {
                plik.createNewFile();
            }
            FileWriter strumienZapisu = new FileWriter(plik);
            strumienZapisu.write(tekstDoZapisania);
            strumienZapisu.close();

        } catch (IOException io) {
            System.out.println(io.getMessage());

        }


        //	ODCZYT Z PLIKU TEKSTOWEGO
        String odczytanyTekst = "";
        char[] buf = new char[310];
        try {
            FileReader strumienOdczytu = new FileReader(plik);
            strumienOdczytu.read(buf, 0, 300);

        } catch (Exception io) {
            System.out.println(io.getMessage());

        }

        String tekstOdczytany = new String(buf);
        System.out.println("Odczytalem zdanie: " + tekstOdczytany);


        // pkt 3, 4
        //Tworzenie tablicy liczb losowych
        Random random = new Random();
        int[] tablica = new int[20];

        System.out.print("\nTablica liczb losowych: ");
        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = random.nextInt(300);
            System.out.print(tablica[i] + "   ");
        }

        // Zapis do pliku
        try {
            DataOutputStream strumienTablicy = new DataOutputStream(new FileOutputStream(".\\src\\main\\tablica.bin"));
            for (int value : tablica) {
                strumienTablicy.writeInt(value);
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        // Odczyt z pliku
        int[] nowaTalica = new int[20];

        try {
            DataInputStream strumienTablicaZPliku =
                    new DataInputStream(new FileInputStream(".\\src\\main\\tablica.bin"));
            for (int i = 0; i < nowaTalica.length; i++) {
                nowaTalica[i] = strumienTablicaZPliku.readInt();
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        Arrays.sort(nowaTalica);
        System.out.print("\nOdczytana i posortowana: ");
        for (int value : nowaTalica) {
            System.out.print(value + "   ");
        }







        //=============Wczesniejsze zadania==============

        ArrayList<Media> medias = new ArrayList<>();
        init(medias);
        //start(medias);

        System.out.println("\n");
        System.out.println("==============XML================");
        //arraylist do pliku .xml
        XmlConverter.convertToXML(medias);


        //plik .xml do arraylist
        ArrayList<Media> nowaListaZxml = XmlConverter.convertFromXML(new File(".\\src\\serialization\\medias.xml"));
        for (Media m : nowaListaZxml) {
            System.out.println(m.toString());
        }


        System.out.println("=============CSV===============");
        //arraylist do pliku csv
        CsvConverter.convertToCSV(medias);


        //plik .csv do arraylist
        ArrayList<Media> nowaListaZcsv = CsvConverter.convertFromCSV(new File(".\\src\\serialization\\medias.csv"));
        for (Media m : nowaListaZcsv) {
            System.out.println(m.toString());
        }

        //============================================================
    }

    public static void init(ArrayList<Media> medias) {
        medias.add(new Book("Unknown Kimi Raikkonen", "Biography", "Kari Hotakainen", "2018", "336"));
        medias.add(new Book("Green Mile", "Novel", "Stephen King", "1996", "416"));
        medias.add(new Book("Alchemist", "Novel", "Paulo Coelho", "1988", "163"));
        medias.add(new Movie("Star Wars: Return of the Jedi", "Science fiction", "Richard Marquand", "1983", "132"));
        medias.add(new Movie("Green Book", "Biographical comedy-drama", "Peter Farrelly", "2018", "130"));
        medias.add(new Movie("Hobbit: An Unexpected Journey", "Fantasy", "Peter Jackson", "2012", "169"));
    }

    public static void start(ArrayList<Media> medias) {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        do {
            System.out.println(
                    "1.Add \n" +
                            "2.Print \n" +
                            "3.Sort \n" +
                            "4.Quit"
            );

            switch (scanner.nextInt()) {
                case 1:
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

                        medias.add(new Movie(title, genre, director, releaseDate, length));
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

                        medias.add(new Book(title, genre, author, publicationDate, pages));
                    }
                    break;
                case 2:
                    System.out.println(
                            "1.Books \n" +
                                    "2.Movies \n" +
                                    "3.All"
                    );

                    choice = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("================================================================================================================================================================");
                    for (Media m : medias) {
                        if (null != m) {
                            if (choice == 1 && (m instanceof Book)) {
                                System.out.println(m.toString());
                            } else if (choice == 2 && (m instanceof Movie)) {
                                System.out.println(m.toString());
                            } else if (choice == 3) {
                                System.out.println(m.toString());
                            }
                        }
                    }
                    System.out.println("================================================================================================================================================================\n");
                    break;
                case 3:
                    System.out.println(
                                    "1.byTitle \n" +
                                    "2.byGenre \n" +
                                    "3.byAuthor/Director \n" +
                                    "4.byReleaseDate \n" +
                                    "5.byLength"
                    );


                    choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) {
                        Collections.sort(medias, new SortByTitle());
                    } else if (choice == 2) {
                        Collections.sort(medias, new SortByGenre());
                    } else if (choice == 3) {
                        Collections.sort(medias, new SortByAuthor());
                    } else if (choice == 4) {
                        Collections.sort(medias, new SortByRealeaseDate());
                    } else if (choice == 5) {
                        Collections.sort(medias, new SortlByLenght());
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
