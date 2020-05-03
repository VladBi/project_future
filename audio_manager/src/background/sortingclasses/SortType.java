package background.sortingclasses;

import background.filemanager.Media;

import java.util.Comparator;

public class SortType implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        return o1.getFileType().compareTo(o2.getFileType());
    }
}
