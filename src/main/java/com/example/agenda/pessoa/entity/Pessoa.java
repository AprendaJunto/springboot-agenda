package com.example.agenda.pessoa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer idade;
    @Column(nullable = false)
    private String telefone;

    protected Pessoa() {
        // Somente para JPA
    }

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
