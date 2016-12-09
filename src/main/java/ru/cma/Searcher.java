package ru.cma;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Searcher {
    private List<File> fileList = new ArrayList<File>();

    public File pathToFolder(String path) {
        File folder = new File(path);
        return folder;
    }

    public List<File> findAllTXT(File folder) throws FileNotFoundException {

        File[] files = folder.listFiles();
        if (files == null) {
            throw new FileNotFoundException();
        }
        for (File entity : files) {
            if (entity.isDirectory()) {
                findAllTXT(entity);
            } else {
                if (entity.getAbsolutePath().endsWith(".txt")) {
                    fileList.add(entity);
                }
            }
        }
        return comparing(fileList);
    }

    public List<File> comparing(List<File> fileList) {
        Collections.sort(fileList, Comparator.comparing(File::getName));
        return fileList;
    }
}