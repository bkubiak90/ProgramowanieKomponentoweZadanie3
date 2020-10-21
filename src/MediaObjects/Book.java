package MediaObjects;

import java.util.Objects;

public class Book extends Media implements Comparable {

    private String author;
    private String publicationDate;
    private String pages;

    public Book() {
    }

    public Book(String title, String genre, String author, String publicationDate, String pages) {
        super(title, genre);
        this.author = author;
        this.pages = pages;
        this.publicationDate = publicationDate;
    }

    public Book(Movie movie) {
        super.setTitle(movie.getTitle());
        super.setGenre(movie.getGenre());
        this.author = movie.getDirector();
        this.publicationDate = movie.getReleaseDate();
        this.pages = movie.getRunningTime();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }


    @Override
    public String toString() {
        return String.format("%-8sTitle: %-35sAuthor: %-22sGenre: %-27sPubicationDate: %-10sPages: %-10s", "Book",
                getTitle(), author, getGenre(), publicationDate, pages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getPublicationDate(), book.getPublicationDate()) &&
                Objects.equals(getPages(), book.getPages()) &&
                Objects.equals(super.getTitle(), book.getTitle()) &&
                Objects.equals(super.getGenre(), book.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getPublicationDate(), getPages(), super.getTitle(), super.getGenre());
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() == this.getClass()) {
            Book book = (Book) o;
            return this.toString().compareToIgnoreCase(book.toString());
        }
        return -1;
    }
}
