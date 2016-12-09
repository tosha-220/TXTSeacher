package ru.cma;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class Writer {
    private FileWriter fileWriter;
    private Logger logger = Logger.getLogger(getClass().getName());

    public void writingToTXT(List<String> textList, String path) {
        try {
            if (textList.size() > 0) {
                fileWriter = new FileWriter(path + "text.txt");
                for (String x : textList) {

                    if (x != null)
                        fileWriter.write(x);
                    lineSeparator();
                    fileWriter.flush();
                }
                logger.info("Successfully write text.txt");
            }
        } catch (IOException e) {
            logger.info("Incorrect path or access denied");
        }
    }

    private void lineSeparator() throws IOException {
        fileWriter.write(System.getProperty("line.separator"));
    }
}