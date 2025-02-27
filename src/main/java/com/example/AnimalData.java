package com.example;

import java.time.Instant;

public class AnimalData {
    private String id;
    private String name;
    private Instant timestamp;
    private double latitude;
    private double longitude;

    public AnimalData(String id, String name, Instant timestamp, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public AnimalData() {
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Timestamp: %s, Location: [Latitude: %.6f, Longitude: %.6f]",
                id, name, timestamp, latitude, longitude);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
