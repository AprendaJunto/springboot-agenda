package com.example.agenda.pessoa.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "telefones")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String numero;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    protected Telefone(){
        //Somente para JPA
    }

    public Telefone(String numero, TipoTelefone tipoTelefone, Pessoa pessoa) {
        this.numero = numero;
        this.tipoTelefone = tipoTelefone;
        this.pessoa = pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
