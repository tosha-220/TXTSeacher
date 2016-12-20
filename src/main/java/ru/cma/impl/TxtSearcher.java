package ru.cma.impl;

import ru.cma.api.ISearcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TxtSearcher implements ISearcher {

    private List<File> fileList;

    public TxtSearcher() {
        fileList = new ArrayList<>();
    }

    public File pathToFolder(String path) {
        return new File(path);
    }

    public List<File> findAllFiles(File folder) throws FileNotFoundException {

        File[] files = folder.listFiles();
        if (files == null) {
            throw new FileNotFoundException("Files .txt not found");
        }
        for (File file : files) {
            if (file.isDirectory()) {
                findAllFiles(file);
            } else {
                if (file.getAbsolutePath().endsWith(".txt")) {
                    fileList.add(file);
                }
            }
        }
        return sort(fileList);
    }

    private List<File> sort(List<File> fileList) {
        fileList.sort(Comparator.comparing(File::getName));
        return fileList;
    }
}