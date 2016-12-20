package ru.cma;

import org.junit.Assert;
import org.junit.Test;
import ru.cma.impl.TxtReader;
import ru.cma.impl.TxtSearcher;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class SearchAndReadTest {

    private final static int COUNT_OF_FILES = 2;
    private final static int COUNT_OF_LINES = 194;

    @Test
    public void test() throws FileNotFoundException {
        File file = new File("src/test/resources");
        TxtSearcher txtSearcher = new TxtSearcher();
        TxtReader txtReader = new TxtReader();
        List<File> fileList;
        fileList = txtSearcher.findAllFiles(file);
        Assert.assertEquals("Count of files must be equals " + COUNT_OF_FILES, COUNT_OF_FILES, fileList.size());
        String line = txtReader.read(fileList);
        Assert.assertEquals("Count of lines must be equals " + COUNT_OF_LINES, COUNT_OF_LINES, line.length());
    }
}