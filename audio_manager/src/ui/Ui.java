package ui;

import background.filemanager.Audio;
import background.filemanager.Library;
import background.filemanager.Media;
import background.filemanager.Video;
import background.loader.MediaFileOpener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ui {
    public Choice menu() {
        Choice returnChoice;
        System.out.println("1. Add a file to the library");
        System.out.println("2. Save library");
        System.out.println("3. Load new library");
        System.out.println("4. Sort library by name" );
        System.out.println("5. Sort library by type");
        System.out.println("6. Sort library by date");
        System.out.println("7. Sort library by id");
        System.out.println("8. Show all files");
        System.out.println("9. Delete first item in library");
        System.out.println("10. Give title of file to be deleted");
        System.out.println("11. Delete whole library");
        System.out.println("12. Search in Library");
        System.out.println("0. Close menu");

        int choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return Choice.ADD;
                case 2:
                    return Choice.SAVE;
                case 3:
                    return Choice.LOAD;
                case 4:
                    return Choice.SORT_BY_NAME;
                case 5:
                    return Choice.SORT_BY_TYPE;
                case 6:
                    return Choice.SORT_BY_DATE;
                case 7:
                    return Choice.SORT_BY_ID;
                case 8:
                    return Choice.SHOW_ALL;
                case 9:
                    return Choice.DELETE_FIRST;
                case 10:
                    return Choice.DELETE_TITLE;
                case 11:
                    return Choice.DELETE_ALL;
                case 12 :
                    return Choice.SEARCH;
                case 0:
                    return Choice.CLOSE;
                default:
                    return Choice.ERROR;
            }
        } catch (Exception e) {
            return Choice.ERROR;
        }
    }
        public void addFile(Library library) {
            String fileName;
            String fileType;
            String title;
            int duration = 0;
            float size;
            String typeSpecific;
            Scanner scanner = new Scanner(System.in);

            String temp;
            while (true) {

                System.out.println("Is it an Audio or Video File? ");
                temp = scanner.next();
                if (temp.equalsIgnoreCase("audio") || temp.equalsIgnoreCase("video")) {
                    break;
                } else {
                    System.out.println("Wrong input!!");
                }
            }

            System.out.println("Give the filename ");
            fileName = scanner.next();
            System.out.println("Give the filetype extension ");
            fileType = scanner.next();
            System.out.println("Give the title ");
            title = scanner.next();

            //needs exception check for non integers...assume client is correct
            System.out.println("Give the duration in seconds ");
            try {
                duration = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("something went wrong");
            }


            System.out.println("Give the size");
            size = scanner.nextFloat();

            if (temp.equalsIgnoreCase("Audio")) {
                System.out.println("Give the sound quality");
                typeSpecific = scanner.next();
                library.addMedia(new Audio(fileName,fileType,title,duration,size,typeSpecific));
            } else {
                System.out.println("Give the image quality");
                typeSpecific = scanner.next();
                library.addMedia(new Video(fileName,fileType,title,duration,size,typeSpecific));
            }
        }
        public void manageLibrary () throws IOException {
        Choice choice;
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

            System.out.println("Give path to library or press enter for fresh one");
            String filePath = scanner.next();
            //if(!filePath.equals("") || MediaFileOpener.isLibrary(filePath)) {
            //    library = MediaFileOpener.loadLib(filePath);
            //}

        do {
            choice = menu();
            switch (choice) {
                case SEARCH:
                    System.out.println("Give me whar to search for:");
                    String stringSearch = scanner.next();
                    System.out.println(library.search(stringSearch));
                    break;
                case SAVE:
                    MediaFileOpener.saveLibrary(library);
                    break;
                case LOAD:
                    System.out.println("Give File Path");
                    String filePath2 = scanner.next();
                    library = MediaFileOpener.loadLib(filePath2);
                    break;
                case ADD :
                    addFile(library);
                    break;
                case SORT_BY_NAME :
                    library.sortName();
                break;
                case SORT_BY_TYPE :
                    library.sortType();
                break;
                case SORT_BY_DATE :
                    library.sortDate();
                break;
                case SORT_BY_ID :
                    library.sortId();
                break;
                case SHOW_ALL :
                    System.out.println(library.toString());
                break;
                case DELETE_FIRST :
                    library.removeFirst();
                break;
                case DELETE_TITLE:
                    System.out.println("Give name of title to delete: /n");
                    library.removeByString(scanner.next());
                    break;
                case DELETE_ALL : library.clear();
                break;
                case CLOSE:
                    break;
                case ERROR :
                    System.out.println("Erroneous input");
                    break;
            }
        } while (choice !=Choice.CLOSE);




        }
}
