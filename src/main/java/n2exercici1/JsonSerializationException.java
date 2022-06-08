package n2exercici1;


public class JsonSerializationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public JsonSerializationException(String message) {

        super("merda. Pues es que es " + message);
    }
}