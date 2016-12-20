package ru.cma.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public interface ISearcher {
    List<File> findAllFiles(File folder) throws FileNotFoundException;
}
