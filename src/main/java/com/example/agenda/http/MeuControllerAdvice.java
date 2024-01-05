package com.example.agenda.http;

import com.example.agenda.pessoa.exception.PessoaNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MeuControllerAdvice {

    private static final Log log = LogFactory.getLog(MeuControllerAdvice.class);

    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<Void> notFound(PessoaNotFoundException e) {
        log.warn(e.getMessage());
        return ResponseEntity.notFound().build();
    }


}
