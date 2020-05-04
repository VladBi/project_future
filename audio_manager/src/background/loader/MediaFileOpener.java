package background.loader;

import background.filemanager.Library;
import background.filemanager.Media;

import java.io.*;
import java.util.Scanner;

public class MediaFileOpener {


    public static boolean isLibrary(String filePath) throws FileNotFoundException {
        try {
            FileReader name = new FileReader(filePath);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Not found");
            return false;
        }
    }

   // public static Library loadLib(String filePath) throws FileNotFoundException {
    //    try {
     //       FileReader name = new FileReader(filePath);
    //    } catch (FileNotFoundException e) {

     //   }
    //}

    public static void saveLibrary(Library library) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean append_to_file = false;
        System.out.println("Give destination and name to save");
        String filepath = scanner.next();
        FileWriter writer = new FileWriter(filepath,append_to_file);
        PrintWriter printLine = new PrintWriter(writer);
        printLine.printf("%s" + "%n",library.toString());
        printLine.close();


    }

}
