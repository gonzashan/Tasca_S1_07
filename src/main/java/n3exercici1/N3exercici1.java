package n3exercici1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class N3exercici1 {

    public static final String ON_VAS = "./src/main/resources/";

    public static void main(String[] args)  {

        // Field address will not include into JSON file, lack of annotations indeed.
        Person person = new Person("jesús", "gil", "88","Gran Vía, 7 ");

        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String json = serializer.convertToJson(person);
        String path = serializer.getPathAndFile(person);

        try (OutputStream is = new FileOutputStream(path)){

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue( is, json);
            System.out.println("Proceso completado!");

        } catch (IOException e) {

            System.out.println("Mira, no sale... no sé que pasa");
            System.out.println(e.getMessage());
        }

    }


}
