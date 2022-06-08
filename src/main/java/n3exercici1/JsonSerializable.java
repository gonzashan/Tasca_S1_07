package n3exercici1;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
public @interface JsonSerializable {
    public String action();
    public String value();
    // Have to put above the Object class action to be accepted.
    // If not, a custom exception will be thrown.
    String path() default N3exercici1.ON_VAS;
    //Afegeix la possibilitat que l'anotació creada en el nivell anterior sigui registrada per
    // la Virtual Machine en temps d'execució.
    // Demostra que s'executa la lectura de l'annotation fent servir Java Reflection.
}