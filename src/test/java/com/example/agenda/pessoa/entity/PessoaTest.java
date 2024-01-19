package com.example.agenda.pessoa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PessoaTest {

    private Pessoa pessoa;
    private UUID id;

    @BeforeEach
    public void setUp(){
        id = UUID.randomUUID();
        pessoa = new Pessoa(id, "nome", 44, "9999-9999");
    }

    @Test
    public void deveAtualizarPessoa(){
        //Given -> Arrange
        Pessoa pessoaAtualizada = new Pessoa(UUID.randomUUID(), "novo nome", 22, "1111-1111");

        //When -> act
        pessoa.atualiza(pessoaAtualizada);

        //Then -> assert
        assertEquals(id, pessoa.getId());
        assertEquals("novo nome", pessoa.getNome());
        assertEquals(22, pessoa.getIdade());
    }

    @Test
    public void deveAdicionarTelefone(){
        //Given
        //When
        pessoa.adicionaTelefone("1111-1111", TipoTelefone.CELULAR);

        //Then
        assertEquals(2, pessoa.getTelefones().size());
        Telefone telefone = pessoa.getTelefones().get(1);

        assertEquals("1111-1111", telefone.getNumero());
        assertEquals(TipoTelefone.CELULAR, telefone.getTipoTelefone());
        assertEquals(pessoa, telefone.getPessoa());
    }

}