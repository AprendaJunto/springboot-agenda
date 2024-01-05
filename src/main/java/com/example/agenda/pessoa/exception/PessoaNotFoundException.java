package com.example.agenda.pessoa.exception;

public class PessoaNotFoundException extends RuntimeException {

    public PessoaNotFoundException(String message) {
        super(message);
    }
}
