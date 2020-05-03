package background.sortingclasses;

import background.filemanager.Media;

import java.util.Comparator;

public class SortName implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        return o1.getFileName().compareTo(o2.getFileName());
    }
}
