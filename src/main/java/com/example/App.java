package com.example;

/**
 * Hello world!
 *
 */

// keep track of animals and
// animals should have id, species, location and timestamp
// generate random data, write to a csv
// read data from csv and display in format

// read csv file
// write csv file
// generate random data
public class App {
    public static void generateRandomData() {
        GenerateData generateData = new GenerateData();
        generateData.generateRandomData();
    }

    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        generateRandomData();
    }
}
