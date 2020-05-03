package background.filemanager;

public class Audio extends Media{
    private String soundQuality;

    public Audio(String fileName, String fileType, String title, int duration, float size, String soundQuality) {
        super(fileName, fileType, title, duration, size);
        this.soundQuality = soundQuality;
    }
    public String toString() { return super.toString() + ", Sound Quality: " +getSoundQuality();}

    private String getSoundQuality() { return this.soundQuality;
    }
}
