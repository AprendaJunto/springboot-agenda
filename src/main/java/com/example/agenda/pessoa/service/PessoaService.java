package com.example.agenda.pessoa.service;

import com.example.agenda.pessoa.exception.PessoaNotFoundException;
import com.example.agenda.pessoa.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class PessoaService {

    private final Map<UUID, Pessoa> pessoasCadastradasMap = new HashMap<>();

    public PessoaService() {
        for (int i = 0; i < 10; i++) {
            Pessoa pessoaDTO = new Pessoa(null, "Nome " + i, 18 + i, String.valueOf(i));
            pessoasCadastradasMap.put(pessoaDTO.getId(), pessoaDTO);
        }
    }

    public void cadastra(Pessoa pessoa){
        pessoasCadastradasMap.put(pessoa.getId(), pessoa);
    }

    public Map<UUID, Pessoa> pegaTodos(){
        return pessoasCadastradasMap;
    }

    public Pessoa pegaUnico(UUID id){
        if (!pessoasCadastradasMap.containsKey(id)){
            throw new PessoaNotFoundException("Pessoa com id \"%s\" não encontrada".formatted(id));
        }
        return pessoasCadastradasMap.get(id);
    }

    public Pessoa atualiza(UUID id, Pessoa pessoaAtualizada){
        Pessoa registro = pegaUnico(id);

        registro.atualiza(pessoaAtualizada);

        return registro;
    }

    public void delete(UUID id){
        if (!pessoasCadastradasMap.containsKey(id)){
            throw new PessoaNotFoundException("Pessoa com id \"%s\" não encontrada".formatted(id));
        }
        pessoasCadastradasMap.remove(id);
    }


}
