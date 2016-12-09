package ru.cma;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Reader {
    private List<String> fileContent = new ArrayList<String>();
    private Logger logger = Logger.getLogger(getClass().getName());

    public List<String> getList() {
        return fileContent;
    }

    public void reading(File file) {
        BufferedReader fin = null;
        try {
            fin = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsoluteFile()), "windows-1251"));
        } catch (UnsupportedEncodingException e) {
            logger.info("The Character Encoding is not supported");
        } catch (FileNotFoundException e) {
            logger.info("File not found");
        }
        String str;
        try {

            while ((str = fin.readLine()) != null) {
                fileContent.add(str);
            }
        }
        catch (IOException e) {
            logger.info("File "+file.getName()+" is empty");
        }
    }
}
