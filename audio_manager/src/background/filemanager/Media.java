package background.filemanager;

import java.util.Date;

public class Media {
    private final int id;
    private String fileName;
    private String fileType;
    private String title;
    private int duration;
    private float size;
    private final Date dateOfArchive;

    public Media(String fileName, String fileType, String title, int duration, float size) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.title = title;
        this.duration = duration;
        this.size = size;
        this.dateOfArchive = new Date();
        this.id = this.dateOfArchive.hashCode();
    }

    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public float getSize() {
        return size;
    }

    public Date getDateOfArchive() {
        return dateOfArchive;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){ return "|ID: " + this.getId() +"| Name: " + getFileName() +"| Type: " +getFileType() + "| Title: " + getTitle() + "| Duration: " + getDuration() + "| Size of File: " + getSize() + "| " ;};
}
