package sortobjects;

import mediaobjects.Media;

import java.util.Comparator;

public class SortByGenre implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        if (null != o1 && null != o2) {
            Media m1 = (Media) o1;
            Media m2 = (Media) o2;
            return m1.getGenre().compareToIgnoreCase(m2.getGenre());
        } else if (null == o1) {
            return -1;
        } else if (null == o2){
            return 1;
        }
        return 0;
    }
}
