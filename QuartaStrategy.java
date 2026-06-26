public class QuartaStrategy extends StrategyBase {
    public QuartaStrategy() {
        super(DiaSemana.QUARTA, Prioridade.MEDIA);
    }

    @Override
    protected String criarMensagem(ContextoExecucao contexto) {
        return "Dia de revisão: verifique o andamento da atividade \""
                + contexto.getInformacaoAdicional() + "\".";
    }
}
