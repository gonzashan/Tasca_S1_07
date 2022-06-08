package n2exercici1;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ FIELD })
public @interface JsonElement {

    public String key() default "";
   // Put it above any class variable action to be included into Json file.

}