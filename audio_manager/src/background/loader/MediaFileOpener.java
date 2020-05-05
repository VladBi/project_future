package background.loader;

import background.filemanager.Library;
import background.filemanager.Media;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public static Library loadLib(String filePath) throws FileNotFoundException, IOException, ArrayIndexOutOfBoundsException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        ArrayList<String> listOfMedia= new ArrayList<String>();
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line !=null) {
                listOfMedia.add(line);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not found, creating new one");
            return new Library();
        } finally {
        br.close();
        }
        Library library = new Library();
        Date date= new Date();
        for (String s : listOfMedia) {
            String[] parts = s.split("-");
            String[] dateTemp = parts[6].split(":");
            try {
            date = new Date (Integer.parseInt(dateTemp[0]),Integer.parseInt(dateTemp[1]),Integer.parseInt(dateTemp[2]),Integer.parseInt(dateTemp[3]),Integer.parseInt(dateTemp[4]),Integer.parseInt(dateTemp[5]));
                    library.addMedia(new Media(Integer.parseInt(parts[0]),parts[1],parts[2],parts[3],Integer.parseInt(parts[4]),Float.parseFloat(parts[5]),date));
            } catch (ArrayIndexOutOfBoundsException b) {
                System.out.println( "Something wrong with string");
                return new Library();
            }
        }
        return library;
    }

    public static void saveLibrary(Library library) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean append_to_file = false;
        System.out.println("Give destination and name to save");
        String filepath = scanner.next();
        FileWriter writer = new FileWriter(filepath,append_to_file);
        PrintWriter printLine = new PrintWriter(writer);
        DateFormat dateFormat = new SimpleDateFormat("yyyy:mm:dd hh:mm:ss");
        for (int i = 0; i < library.getSize(); i++) {
            printLine.printf(library.getContent(i).getId() + "-" + library.getContent(i).getFileName() + "-" + library.getContent(i).getFileType() + "-" + library.getContent(i).getTitle() + "-" + library.getContent(i).getDuration() + "-" + library.getContent(i).getSize() + "-" + dateFormat.format(library.getContent(i).getDateOfArchive()));
            printLine.printf("%n");
        }
        printLine.close();


    }

}
