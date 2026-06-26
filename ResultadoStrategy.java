public class ResultadoStrategy {
    private final String diaConsultado;
    private final Prioridade prioridade;
    private final String mensagem;

    public ResultadoStrategy(String diaConsultado, Prioridade prioridade, String mensagem) {
        this.diaConsultado = diaConsultado;
        this.prioridade = prioridade;
        this.mensagem = mensagem;
    }

    public String getDiaConsultado() {
        return diaConsultado;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public String getMensagem() {
        return mensagem;
    }
}
