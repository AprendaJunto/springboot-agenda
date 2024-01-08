package com.example.agenda.pessoa.controller;

import com.example.agenda.pessoa.controller.dto.CadastraPessoaDTO;
import com.example.agenda.pessoa.model.Pessoa;
import com.example.agenda.pessoa.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final PessoaService pessoaService; //Dependemos de pessoaService

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }


    //create
    @PostMapping
    @CrossOrigin("*")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void cadastraPessoa(@RequestBody @Valid CadastraPessoaDTO cadastraPessoaDTO) {
        pessoaService.cadastra(cadastraPessoaDTO.toPessoa());
    }

    //read
    @GetMapping
    @CrossOrigin("*")
    public ResponseEntity<List<CadastraPessoaDTO>> listaPessoas() {
        Map<UUID, Pessoa> pessoasCadadstradas = pessoaService.pegaTodos();

        List<CadastraPessoaDTO> listaPessoas = pessoasCadadstradas.values()
                .stream()
                .map(CadastraPessoaDTO::fromPessoa)
                .toList();

        return ResponseEntity.ok(listaPessoas);
    }

    //read de um unico elemento por ID
    @GetMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<CadastraPessoaDTO> pegaUnico(@PathVariable("id") UUID id) {
        Pessoa pessoa = pessoaService.pegaUnico(id);
        CadastraPessoaDTO body = CadastraPessoaDTO.fromPessoa(pessoa);
        return ResponseEntity.ok(body);
    }

    //U - Update
    @PutMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<CadastraPessoaDTO> atualizar(@PathVariable("id") UUID id,
                                                       @RequestBody @Valid CadastraPessoaDTO cadastroAtualizado) {
        Pessoa registroAtualizado = pessoaService.atualiza(id, cadastroAtualizado.toPessoa());
        CadastraPessoaDTO body = CadastraPessoaDTO.fromPessoa(registroAtualizado);
        return ResponseEntity.ok(body);
    }

    // D - Delete
    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
