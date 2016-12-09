package ru.cma;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Searcher txtFinder = new Searcher();
        Reader readerFromTXT = new Reader();
        File file = txtFinder.pathToFolder(args[0]);
        List<File> filesList = null;
        try {
            filesList = txtFinder.findAllTXT(file);
            if (filesList.size() == 0) {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Files .txt not found in this folder");
            System.exit(0);
        }
        for (File txt : filesList) {
            readerFromTXT.reading(txt);
        }
        List<String> textList = readerFromTXT.getList();
        if(textList.size()==0){
            System.out.println(filesList.size()+" files where found but they were empty");
        }
        Writer writerToTXT = new Writer();
        writerToTXT.writingToTXT(textList, args[1]);
    }
}