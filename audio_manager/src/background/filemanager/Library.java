package background.filemanager;

import background.sortingclasses.SortDate;
import background.sortingclasses.SortId;
import background.sortingclasses.SortName;
import background.sortingclasses.SortType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<Media> library;
    public Library() {
        this.library = new ArrayList<Media>();
    }

    public void addMedia(Media media) {
        if(!library.contains(media)) {
            library.add(media);
        } else {
            System.out.println("Already Exists!");
        }
    }
    public String toString() { return library.toString();}

    public void sortName() {
        Collections.sort(library,new SortName());
    }

    public void sortType() {
        Collections.sort(library, new SortType());
    }

    public void sortId() {
        Collections.sort(library, new SortId());
    }

    public void sortDate() {
        Collections.sort(library, new SortDate());
    }

    public void removeFirst() {
        this.library.remove(0);
    }

    public void clear() {
        this.library.clear();
    }

    public void removeByString(String next) {
        for (Media m : library) {
            if (m.getTitle().contains(next)) {
                library.remove(m);
                break;
            }
        }
    }
}
