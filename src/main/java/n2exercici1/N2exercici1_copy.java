package n2exercici1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class N2exercici1_copy {

    public static final String ON_VAS = "./src/main/resources/";

    public static void main(String[] args) {

        Person person = new Person("jesús", "divino", "33");

        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        //String json = serializer.convertToJson(person);
        String path = serializer.getPathAndFile(person);

        try (OutputStream is = new FileOutputStream(path)){

           // System.out.println(json);
            ObjectMapper mapper = new ObjectMapper();
          //  mapper.writeValue(is,json); // doesn't work properly
            System.out.println("Proceso completado!");

        } catch (IOException e) {

            System.out.println("Mira, no sale... no sé que pasa");
            System.out.println(e.getMessage());
        }

    }

}
