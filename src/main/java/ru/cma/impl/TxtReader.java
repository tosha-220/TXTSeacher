package ru.cma.impl;

import org.apache.log4j.Logger;
import ru.cma.api.IReader;

import java.io.*;
import java.util.List;


public class TxtReader implements IReader {

    private static final Logger log = Logger.getLogger(TxtReader.class);

    public String read(List<File> fileList) {
        StringBuilder sb = new StringBuilder();
        for (File txt : fileList) {
            try (BufferedReader reader = new BufferedReader(new FileReader(txt.getAbsoluteFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append(System.lineSeparator());
                }
            } catch (FileNotFoundException e) {
                log.info("File not found");
            } catch (IOException e) {
                log.error("TxtReader error");
                throw new RuntimeException();
            }
        }
        return sb.toString();
    }
}