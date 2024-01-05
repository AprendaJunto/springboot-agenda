package com.example.agenda.pessoa.service;

import com.example.agenda.pessoa.controller.dto.CadastraPessoaDTO;
import com.example.agenda.pessoa.exception.PessoaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class PessoaService {

    private final Map<UUID, CadastraPessoaDTO> pessoasCadastradasMap = new HashMap<>();

    public PessoaService() {
        for (int i = 0; i < 10; i++) {
            CadastraPessoaDTO pessoaDTO = new CadastraPessoaDTO();
            pessoaDTO.setNome("Nome " + i);
            pessoaDTO.setIdade(18 + i);
            pessoaDTO.setTelefone(String.valueOf(i));

            pessoasCadastradasMap.put(pessoaDTO.getId(), pessoaDTO);
        }
    }

    public void cadastra(CadastraPessoaDTO cadastraPessoaDTO){
        pessoasCadastradasMap.put(cadastraPessoaDTO.getId(), cadastraPessoaDTO);
    }

    public Map<UUID, CadastraPessoaDTO> pegaTodos(){
        return pessoasCadastradasMap;
    }

    public CadastraPessoaDTO pegaUnico(UUID id){
        if (!pessoasCadastradasMap.containsKey(id)){
            throw new PessoaNotFoundException();
        }
        return pessoasCadastradasMap.get(id);
    }

    public CadastraPessoaDTO atualiza(UUID id, CadastraPessoaDTO cadastroAtualizado){
        CadastraPessoaDTO registro = pegaUnico(id);

        registro.atualiza(cadastroAtualizado);

        return registro;
    }

    public void delete(UUID id){
        if (!pessoasCadastradasMap.containsKey(id)){
            throw new PessoaNotFoundException();
        }
        pessoasCadastradasMap.remove(id);
    }


}
