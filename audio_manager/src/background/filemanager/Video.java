package background.filemanager;


public class Video extends Media  {
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


}
