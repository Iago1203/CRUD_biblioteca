package br.com.senai.teste.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public class RenovacaoRequest{
    @NotNull(message ="A data é obrigatória")
    @Future(message = "A data não deve estarno futuro")
    private LocalDate novaDataDevolucao;

    public RenovacaoRequest() {
    }
    public LocalDate getNovaDataDevolucao() {
        return novaDataDevolucao;
    }
    public void setNovaDataDevolucao(LocalDate novaDataDevolucao) {
        this.novaDataDevolucao = novaDataDevolucao;
    }

}