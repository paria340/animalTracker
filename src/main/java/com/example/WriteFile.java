package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    String filePath;

    public WriteFile(String filePath) {
        this.filePath = filePath;
    }

    public void writeCSV(List<AnimalData> animalsList) {
        boolean fileExists = new File(filePath).exists();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            if (!fileExists) {
                bufferedWriter.write("ID,Name,Timestamp,Latitude,Longitude");
                bufferedWriter.newLine();
            }

            for (AnimalData animal : animalsList) {
                String line = String.join(",",
                    animal.getId(),
                    animal.getName(),
                    animal.getTimestamp().toString(),
                    String.valueOf(animal.getLatitude()),
                    String.valueOf(animal.getLongitude())
                );
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
