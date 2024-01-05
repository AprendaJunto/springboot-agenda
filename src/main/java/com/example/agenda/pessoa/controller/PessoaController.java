package com.example.agenda.pessoa.controller;

import com.example.agenda.pessoa.controller.dto.CadastraPessoaDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final Map<UUID, CadastraPessoaDTO> pessoasCadastradasMap = new HashMap<>();

    public PessoaController() {
        for (int i = 0; i < 10; i++) {
            CadastraPessoaDTO pessoaDTO = new CadastraPessoaDTO();
            pessoaDTO.setNome("Nome " + i);
            pessoaDTO.setIdade(18 + i);
            pessoaDTO.setTelefone(String.valueOf(i));

            pessoasCadastradasMap.put(pessoaDTO.getId(), pessoaDTO);
        }
    }

    //create
    @PostMapping
    @CrossOrigin("*")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void cadastraPessoa(@RequestBody @Valid CadastraPessoaDTO cadastraPessoaDTO) {
        System.out.println("ID:" + cadastraPessoaDTO.getId());
        System.out.println("Nome: " + cadastraPessoaDTO.getNome());
        System.out.println("Idade: " + cadastraPessoaDTO.getIdade());
        System.out.println("Telefone: " + cadastraPessoaDTO.getTelefone());

        pessoasCadastradasMap.put(cadastraPessoaDTO.getId(), cadastraPessoaDTO);

    }

    //read
    @GetMapping
    @CrossOrigin("*")
    public ResponseEntity<List<CadastraPessoaDTO>> listaPessoas() {
        return ResponseEntity.ok(new ArrayList<>(pessoasCadastradasMap.values()));
    }

    //read de um unico elemento por ID
    @GetMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<CadastraPessoaDTO> pegaUnico(@PathVariable("id") UUID id) {
        if (pessoasCadastradasMap.containsKey(id)) {
            return ResponseEntity.ok(pessoasCadastradasMap.get(id));
        }
        return ResponseEntity.notFound().build();
    }

    //U - Update
    @PutMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<CadastraPessoaDTO> atualizar(@PathVariable("id") UUID id,
                                                       @RequestBody @Valid CadastraPessoaDTO cadastroAtualizado) {
        if (!pessoasCadastradasMap.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        CadastraPessoaDTO pessoaDTO = pessoasCadastradasMap.get(id);
        pessoaDTO.atualiza(cadastroAtualizado);

        return ResponseEntity.ok(pessoaDTO);
    }

    // D - Delete
    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        if (!pessoasCadastradasMap.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        pessoasCadastradasMap.remove(id);
        return ResponseEntity.noContent().build();
    }

}
