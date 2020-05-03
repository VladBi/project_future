package background.loader;

import background.filemanager.Library;
import background.filemanager.Media;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public static class MediaFileOpener {


    public static boolean isLibrary(String filePath) throws FileNotFoundException {
        try {
            FileReader name = new FileReader(filePath);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Not found");
            return false;
        }
    }

    public static Library loadLib(String filePath) throws FileNotFoundException {
        try {
            FileReader name = new FileReader(filePath);
        } catch (FileNotFoundException e) {

        }
    }

    public static void saveLibrary(Library library) {
        
    }

}
