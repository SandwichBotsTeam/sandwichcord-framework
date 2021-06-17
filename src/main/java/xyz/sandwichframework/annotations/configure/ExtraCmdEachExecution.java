package xyz.sandwichframework.annotations.configure;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
/**
 * Identifica el metodo que se ejecutara cada medio segundo mientras se espera respuesta.
 * Identifies the method wich will run every half second while the extra command wait for a response.
 * @author Juan Acuña
 * @version 1.0
 * Requiere ser usado en una clase con la anotacion {@link ExtraCommandContainer}.
 * Requires be used in a class with the annotation {@link ExtraCommandContainer}.
 */
public @interface ExtraCmdEachExecution {
	String name();
}
