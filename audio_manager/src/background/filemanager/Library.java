package background.filemanager;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Media> library;
    public Library() {
        this.library = new ArrayList<Media>();
    }

    public void addMedia(Media media) {
        library.add(media);
    }
    public String toString() { return library.toString();}

    public void sortName() {

    }
}
