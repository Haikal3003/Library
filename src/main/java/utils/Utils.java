package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    public static int generateRandomId() {
        return new Random().nextInt(10000);
    }

    public static JSONArray readJsonFile(String filePath) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            return (JSONArray) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public static void writeJsonFile(String filePath, Object object){
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            File file = new File(filePath);
            objectMapper.writeValue(file, object);
        }catch (IOException e){
            System.out.print("an error occurred while saving data to a file: " + e.getMessage());        }

    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void backToMenu(Scanner input, boolean back){
        if(back){
            System.out.print("Enter (y) back to menu: ");
            String backToMenu = input.nextLine();
    
            if(backToMenu.equals("y")){
                Utils.clearScreen();
            }
            
        }
    }


}
