package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextEditorModel {
    private List<String> lines;

    public TextEditorModel() {
        lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public List<String> getLines() {
        return lines;
    }

    public void saveToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (String line : lines) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filePath) {
        lines.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recursiveFileSearch(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    recursiveFileSearch(file.getAbsolutePath());
                } else {
                    // Do something with the file
                }
            }
        }
    }}