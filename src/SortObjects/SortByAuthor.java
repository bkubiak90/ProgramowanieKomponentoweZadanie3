package SortObjects;

import MediaObjects.Book;
import MediaObjects.Media;
import MediaObjects.Movie;

import java.util.Comparator;

public class SortByAuthor implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        if (null != o1 && null != o2) {
            Media m1 = (Media) o1;
            Media m2 = (Media) o2;

            if (m1.getClass() == Book.class) {
                Book b1 = (Book) o1;
                if (m2.getClass() == Book.class) {
                    Book b2 = (Book) o2;
                    return b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
                } else if (m2.getClass() == Movie.class) {
                    Movie mv2 = (Movie) o2;
                    return b1.getAuthor().compareToIgnoreCase(mv2.getDirector());
                }
            } else if (m1.getClass() == Movie.class) {
                Movie mv1 = (Movie) o1;
                if (m2.getClass() == Book.class) {
                    Book b2 = (Book) o2;
                    return mv1.getDirector().compareToIgnoreCase(b2.getAuthor());
                } else if (m2.getClass() == Movie.class) {
                    Movie mv2 = (Movie) o2;
                    return mv1.getDirector().compareToIgnoreCase(mv2.getDirector());
                }
            }
        } else if (null == o1) {
            return -1;
        } else if (null == o2){
            return 1;
        }
        return 0;
    }
}
