package com.example.agenda.pessoa.service;

import com.example.agenda.pessoa.entity.Pessoa;
import com.example.agenda.pessoa.entity.TipoTelefone;
import com.example.agenda.pessoa.exception.PessoaNotFoundException;
import com.example.agenda.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void cadastra(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    public List<Pessoa> pegaTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa pegaUnico(UUID id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
    }

    public Pessoa atualiza(UUID id, Pessoa pessoaAtualizada) {
        Pessoa registro = pegaUnico(id);

        registro.atualiza(pessoaAtualizada);

        return pessoaRepository.save(registro);
    }

    public void delete(UUID id) {
        if (!pessoaRepository.existsById(id)) {
            throw new PessoaNotFoundException(id);
        }
        pessoaRepository.deleteById(id);
    }


    public void cadastraTelefone(UUID id, String numero, TipoTelefone tipoTelefone) {
        Pessoa pessoa = pegaUnico(id);
        pessoa.adicionaTelefone(numero, tipoTelefone);

        pessoaRepository.save(pessoa);
    }
}
