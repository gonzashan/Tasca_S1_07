package n3exercici1;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
public @interface JsonPathFile {

    public String path() default N3exercici1.ON_VAS;
   // Contains Json file path.

}