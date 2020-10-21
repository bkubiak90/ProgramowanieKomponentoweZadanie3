package MediaObjects;

public class Media {

    private String title;
    private String genre;

    public Media() {
    }

    public Media(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", genre='" + genre + '\'';
    }

}
