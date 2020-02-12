package hu.callinghour.model.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileWriter {

    public void write(String filename, String content) {
        try {
            Files.write(Paths.get(filename), Collections.singletonList(content));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
