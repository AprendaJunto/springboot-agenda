package com.example.agenda;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @GetMapping("/hello")
    public ResponseEntity<String> HelloWorld(){
        return ResponseEntity.ok("Se inscreva!!!");
    }
}
