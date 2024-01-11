package com.example.agenda.pessoa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
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
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Telefone> telefones;

    protected Pessoa() {
        // Somente para JPA
    }

    public Pessoa(UUID id, String nome, Integer idade, String telefone) {
        this.id = Objects.isNull(id) ? UUID.randomUUID() : id;
        this.nome = nome;
        this.idade = idade;

        this.telefones = new ArrayList<>();
        this.telefones.add(new Telefone(telefone, TipoTelefone.RESIDENCIAL, this));
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void atualiza(Pessoa pessoaAtualizada) {
        this.nome = pessoaAtualizada.getNome();
        this.idade = pessoaAtualizada.getIdade();
        //this.telefone = pessoaAtualizada.getTelefone();
    }

    public void adicionaTelefone(String numero, TipoTelefone tipoTelefone) {
        this.telefones.add(new Telefone(numero, tipoTelefone, this));
    }
}
