package n2exercici1;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
public @interface JsonPathFile {

   // Returns Json file path.
    public String path() default N2exercici1.ON_VAS;

}