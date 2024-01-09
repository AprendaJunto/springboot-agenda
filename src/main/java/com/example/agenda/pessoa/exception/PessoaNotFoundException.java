package com.example.agenda.pessoa.exception;

import java.util.UUID;

public class PessoaNotFoundException extends RuntimeException {

    public PessoaNotFoundException(UUID id){
        super("Pessoa com id \"%s\" não encontrada".formatted(id));
    }
}
