package ru.cma.api;

import java.io.File;
import java.util.List;

public interface IReader {
    String read(List<File> fileList);
}