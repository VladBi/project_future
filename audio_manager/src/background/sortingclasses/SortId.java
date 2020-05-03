package background.sortingclasses;

import background.filemanager.Media;

import java.util.Comparator;

public class SortId implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        if (o1.getId() < o2.getId()) {
            return -1;
        } else if (o1.getId() == o2.getId()) {
            return 0;
        } else {
            return 1;
        }
    }
}
