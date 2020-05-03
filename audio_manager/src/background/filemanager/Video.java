package background.filemanager;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Video extends Media implements Comparator {
    private String imageQuality;


    public Video(String fileName, String fileType, String title, int duration, float size, String imageQuality) {
        super(fileName, fileType, title, duration, size);
        this.imageQuality = imageQuality;
    }

    public String toString() {
        return super.toString() + ", Sound Quality: " + getImageQuality();
    }

    private String getImageQuality() {
        return this.imageQuality;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Video v1 = (Video)o1;
        Video v2 = (Video)o2;

        return 0;
    }
}
