package background.sortingclasses;

import background.filemanager.Media;

import java.util.Comparator;

public class SortTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
