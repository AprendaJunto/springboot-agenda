package com.example.agenda.pessoa.model;

import java.util.Objects;
import java.util.UUID;

public class Pessoa {

    private UUID id;
    private String nome;
    private Integer idade;
    private String telefone;

    public Pessoa(UUID id, String nome, Integer idade, String telefone) {
        this.id = Objects.isNull(id) ? UUID.randomUUID() : id;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void atualiza(Pessoa pessoaAtualizada) {
        this.nome = pessoaAtualizada.getNome();
        this.idade = pessoaAtualizada.getIdade();
        this.telefone = pessoaAtualizada.getTelefone();
    }
}
