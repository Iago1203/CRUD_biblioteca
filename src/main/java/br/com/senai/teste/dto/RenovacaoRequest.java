
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