package com.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateData {
    final String FILE_PATH = "src/main/java/com/example/speciesList.csv";
    final String DESTINATION_FILE_PATH = "src/main/java/com/example.newFile.csv";

    private UUID generateUUID() {
        return UUID.randomUUID();
    }
    
    private Instant generateTimeStamp() {
        return Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt());
    }

    private Map<Double, Double> createRandomPoint() {
        Map<Double, Double> position = new HashMap<>();
        double latitude = (Math.random() * 180.0) - 90.0;
        double longitude = (Math.random() * 360.0) - 180.0;
        position.put(latitude, longitude);
        return position;
    }

    private String[] getRandomAnimal(){
        ReadFile readFile = new ReadFile(FILE_PATH);
        List<String[]> allData = readFile.readCSV();
        if (allData.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * allData.size());
        return allData.get(randomIndex);
    }

    public void generateRandomData() {
        List<AnimalData> animalsList = new ArrayList<>();
        
        String animalID = generateUUID().toString();

        String[] animalArray = getRandomAnimal();
        String animal = animalArray != null ? String.join(" ", animalArray) : "Unknonwn";
        
        Instant date = generateTimeStamp();
        Map<Double, Double> location = createRandomPoint();
        double latitude = location.keySet().iterator().next();
        double longitude = location.get(latitude);

        AnimalData animalData = new AnimalData(animalID, animal, date, latitude, longitude);
        animalsList.add(animalData);

        for (AnimalData data : animalsList) {
            System.out.println(data);
        }

        WriteFile writeFile = new WriteFile(DESTINATION_FILE_PATH);
        writeFile.writeCSV(animalsList);
    }

}
