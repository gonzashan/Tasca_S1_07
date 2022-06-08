package n2exercici1;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

public class N2exercici1 {

    public static final String ON_VAS = "./src/main/resources/";
    private static FileWriter file;


    public static void main(String[] args) {

        Person person = new Person("jesús", "divino", "33");

        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String json = serializer.convertToJson(person);
        String path = serializer.getPathAndFile(person);

        try (OutputStream is = new FileOutputStream(path)){

            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter(path);
            file.write(json);
            System.out.println("Successfully Created JSON Object to File...");
            System.out.println("\nJSON Object: " + json);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
