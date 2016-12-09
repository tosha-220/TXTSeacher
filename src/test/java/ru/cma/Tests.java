package ru.cma;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Tests {
    File file = new File("src/main/resources");
    Searcher searcher = new Searcher();
    Reader reader = new Reader();


    @Test
    public void tests() throws FileNotFoundException {
        List<File> list = searcher.findAllTXT(file);
        Assert.assertEquals(2, list.size());
        for (File txt : list) {
            reader.reading(txt);
        }
        List<String> str = reader.getList();
        Assert.assertEquals(12, str.size());
    }
}