package pe.edu.upao.sistemas.todoapp.config.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

   @ExceptionHandler(UnAuthenticated.class)
   protected ResponseEntity<Object> handleUnAuthenticated(UnAuthenticated ex) {

       return ResponseEntity.status(401).body("Usted no tiene permisos para acceder.");
   }

    @ExceptionHandler(ValidateException.class)
    protected ResponseEntity<Object> handleValidation(ValidateException ex) {

        return ResponseEntity.status(400).body(ex.getMessage());
    }
}