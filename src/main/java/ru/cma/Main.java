package ru.cma;

import org.apache.log4j.Logger;
import ru.cma.impl.TxtReader;
import ru.cma.impl.TxtSearcher;
import ru.cma.impl.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        List<File> filesList = null;
        try {
            TxtSearcher txtFinder = new TxtSearcher();
            File file = txtFinder.pathToFolder(args[0]);

            filesList = txtFinder.findAllFiles(file);
            if (filesList.size() == 0) {
                throw new FileNotFoundException("FilesList is empty");
            }
        } catch (FileNotFoundException e) {
            log.error("Files .txt not found in this folder");
            System.exit(0);
        }
        TxtReader txtReader = new TxtReader();
        Writer writerToTXT = new Writer();
        writerToTXT.writingToTXT(txtReader.read(filesList), args[1]);
    }
}