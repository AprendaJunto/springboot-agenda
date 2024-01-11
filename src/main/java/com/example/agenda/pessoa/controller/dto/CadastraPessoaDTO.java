package com.example.agenda.pessoa.controller.dto;

import com.example.agenda.pessoa.entity.Pessoa;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class CadastraPessoaDTO {

    private UUID id = UUID.randomUUID();

    @NotBlank(message = "Nome não pode ficar em branco")
    private String nome;

    @Min(value = 0, message = "Idade deve ser no minimo 0")
    @Max(value = 120, message = "Idade deve ser no maximo 120")
    private Integer idade;

    @NotBlank(message = "Telefone não pode ficar em branco")
    private String telefone;

    public CadastraPessoaDTO() {
    }

    public CadastraPessoaDTO(UUID id, String nome, Integer idade, String telefone) {
        this.id = id;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoa toPessoa() {
        return new Pessoa(
                this.id,
                this.nome,
                this.idade,
                this.telefone
        );
    }

    public static CadastraPessoaDTO fromPessoa(Pessoa pessoa) {
        return new CadastraPessoaDTO(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getIdade(),
                pessoa.getTelefones().get(0).getNumero()
        );
    }
}
