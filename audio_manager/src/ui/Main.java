package ui;

import background.filemanager.Library;

public class Main {
    public static void main(String[] args) {
        Ui ui = new Ui();
        Library library = new Library();
        ui.manageLibrary(library);
    }

}
