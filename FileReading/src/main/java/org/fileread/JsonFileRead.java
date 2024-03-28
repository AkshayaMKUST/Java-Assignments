package org.fileread;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JsonFileRead {
    public void readContent() {
        try {
            String filePath = "C:/Users/245239/Desktop/Java/FileReading/src/main/resources/static/input/sample1.json";

            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(new FileReader(filePath));

            JSONArray jsonArray = (JSONArray) object;
            System.out.println("Json Contents are : ");
            for (Object jsonElement : jsonArray) {
                System.out.println(jsonElement);
            }
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Add new key-value pair to a specific object");
                System.out.println("2. Edit an existing key-value pair");
                System.out.println("3. Exit");

                System.out.println("Enter your choice:");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addKeyValue(jsonArray);
                        break;
                    case 2:
                        editKeyValue(jsonArray);
                        break;
                    case 3:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (choice != 3);
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading or writing JSON file: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error parsing JSON file: " + e.getMessage());
        }
    }
    public void editKeyValue(JSONArray jsonArray){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of the object you want to edit (from 0) :");
        int objectIndex = Integer.parseInt(scanner.nextLine());
        if (objectIndex < 0 || objectIndex >= jsonArray.size()) {
            System.out.println("Invalid object index. Exiting...");
            return;
        }

        JSONObject selectedObject = (JSONObject) jsonArray.get(objectIndex);
        System.out.println("Enter the keys to edit for this object :");
        String keysInput = scanner.nextLine();
        String[] keys = keysInput.split(",");

        for (String key : keys) {
            System.out.println("Enter new value for key '" + key.trim() + "':");
            String value = scanner.nextLine();
            selectedObject.put(key.trim(), value);
        }

        String outputFilePath = "C:/Users/245239/Desktop/Java/FileReading/src/main/resources/static/output/outputfile.json";
        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            fileWriter.write(jsonArray.toJSONString());
            System.out.println("Object edited successfully.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addKeyValue(JSONArray jsonArray){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of the object you want to modify (from 0) : ");
        int objectIndex = Integer.parseInt(scanner.nextLine());
        if (objectIndex < 0 || objectIndex >= jsonArray.size()) {
            System.out.println("Invalid object index. Exiting...");
            return;
        }

        JSONObject selectedObject = (JSONObject) jsonArray.get(objectIndex);
        System.out.println("Enter new key for the selected object:");
        String newKey = scanner.nextLine();
        System.out.println("Enter value for " + newKey + ":");
        String newValue = scanner.nextLine();
        selectedObject.put(newKey, newValue);

        String outputFilePath = "C:/Users/245239/Desktop/Java/FileReading/src/main/resources/static/output/outputfile.json";
        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            fileWriter.write(jsonArray.toJSONString());
            System.out.println("Object edited successfully.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
