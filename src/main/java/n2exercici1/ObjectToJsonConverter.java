package n2exercici1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectToJsonConverter {

    public String convertToJson(Object object) throws JsonSerializationException {
        try {

            checkIfSerializable(object);
            initializeObject(object);
            return getJsonString(object);

        } catch (Exception e) {

            throw new JsonSerializationException(e.getMessage());
        }
    }

    public String getPathAndFile(Object object) throws JsonSerializationException {

        try {

            return getPathFile(object);

        } catch (Exception e) {

            throw new JsonSerializationException(e.getMessage());
        }
    }

    // Parameter received must be an Object
    private void checkIfSerializable(Object object) {
        if (Objects.isNull(object)) {
            throw new JsonSerializationException("No se puede serializar un Objeto nulo.");
        }
        // must be labeled with its proper annotations
        Class<?> clazz = object.getClass();
        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            throw new JsonSerializationException("La clase " + clazz.getSimpleName()
                    + " tiene la anotación: JsonSerializable");
        }
    }

    private void initializeObject(Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //Wildcard to capture any kind of class
        Class<?> clazz = object.getClass();
        // Recollecting methods from the serializable class and check if
        // any of them has the annotation present just above them.
        for (Method method : clazz.getDeclaredMethods()) {

            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                // the method will be invoking
                method.invoke(object);
            }
        }
    }

    private String getPathFile(Object object) throws IllegalArgumentException, IllegalAccessException {

        Class<?> clazz = object.getClass();

        if (!clazz.isAnnotationPresent(JsonPathFile.class) ||
                !clazz.isAnnotationPresent(JsonFile.class)) {
            throw new JsonSerializationException("La clase " + clazz.getSimpleName()
                    + " no tiene la anotación:\n" +
                    "JsonPathFile o JsonFile");
        } else {

           // return clazz.getAnnotation(JsonSerializable.class).path();
            return clazz.getAnnotation(JsonPathFile.class).path()
                    + clazz.getAnnotation(JsonFile.class).fileName();
        }

    }

    private String getJsonString(Object object) throws IllegalArgumentException, IllegalAccessException {

        Class<?> clazz = object.getClass();
        // Creates a map to get in elements from object send it.
        Map<String, String> jsonElementsMap = new HashMap<>();

        // Collecting all the field inside the class
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            // As before this the class. Ask if they have present the annotation to be included in Json file
            if (field.isAnnotationPresent(JsonElement.class)) {
                // Put into the map
                jsonElementsMap.put(getKey(field), (String) field.get(object));
            }
        }

        //Streaming the map and build the Json structure with each list element
        //And finally return them to write Json file.
        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }

    private String getKey(Field field) {
        //Obtaining values from fields to create the key.
        String value = field.getAnnotation(JsonElement.class)
                .key();
        return value.isEmpty() ? field.getName() : value;
    }
}