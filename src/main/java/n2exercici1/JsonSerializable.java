package n2exercici1;


import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface JsonSerializable {

    // Have to put above the Object class action to be accepted.
    // If not, a custom exception will be thrown.
    public String path() default N2exercici1.ON_VAS;
}