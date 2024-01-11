package com.example.agenda.pessoa.controller.dto;

import com.example.agenda.pessoa.entity.TipoTelefone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CadastroTelefoneDTO {

    @NotBlank(message = "Numero não pode ficar em branco")
    private String numero;

    @NotNull
    private TipoTelefone tipoTelefone;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
