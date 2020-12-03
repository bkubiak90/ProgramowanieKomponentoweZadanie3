package serialization;

import com.thoughtworks.xstream.XStream;
import mediaobjects.Book;
import mediaobjects.Media;
import mediaobjects.Movie;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class XmlConverter {



    public static void convertToXML (ArrayList<Media> list) {

        XStream xStream = new XStream();
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(new File(".\\src\\serialization\\medias.xml"));
            xStream.alias("Book", Book.class);
            xStream.alias("Movie", Movie.class);
            xStream.alias("Biblioteka", List.class);
            xStream.toXML(list, fileWriter);
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList convertFromXML (File xml) {

        XStream xStream = new XStream();
        xStream.alias("Book", Book.class);
        xStream.alias("Movie", Movie.class);
        xStream.alias("Biblioteka", List.class);
        Class<?>[] classes = new Class[] { Media.class, Movie.class, Book.class };
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(classes);

        return (ArrayList) xStream.fromXML(xml);
    }

}
