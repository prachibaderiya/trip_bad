package com.prachiBaderiya.project.exception;
import com.prachiBaderiya.project.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<Object> handleNotFound(ResourceNotFoundException ex) {
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new
ApiError(404, ex.getMessage()));
}
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Object>
handleValidation(MethodArgumentNotValidException ex) {
Map<String, String> errors = new HashMap<>();
ex.getBindingResult().getFieldErrors().forEach(err ->
errors.put(err.getField(), err.getDefaultMessage()));
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
}
@ExceptionHandler(Exception.class)
public ResponseEntity<Object> handleGeneric(Exception ex) {
return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new
ApiError(500, ex.getMessage()));
}
}
