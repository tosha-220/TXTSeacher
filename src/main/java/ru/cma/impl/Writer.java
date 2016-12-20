package ru.cma.impl;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    private static final Logger log = Logger.getLogger(Writer.class);

    public void writingToTXT(String allLines, String path) {

        try (FileWriter fileWriter = new FileWriter(path + "text.txt")) {
            if (allLines.length() > 0) {
                System.out.println(allLines);
                fileWriter.write(allLines);
            }
            fileWriter.flush();

            log.info("Successfully write text.txt");

        } catch (IOException e) {
            log.info("Incorrect path or access denied");
        }
    }
}