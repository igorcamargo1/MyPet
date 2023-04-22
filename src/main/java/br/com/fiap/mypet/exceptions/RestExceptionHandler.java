package br.com.fiap.mypet.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.fiap.mypet.models.RestValidationErro;

@RestControllerAdvice
public class RestExceptionHandler {
    
    Logger log = LoggerFactory.getLogger(getClass());
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<RestValidationErro>> MethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error("erro de validacao");

        List<RestValidationErro> erros = new ArrayList<>();
        
        e.getFieldErrors().forEach(v -> erros.add(new RestValidationErro(v.getField(), v.getDefaultMessage())));
        

        return ResponseEntity.badRequest().body(erros);

        

    }
    
}
