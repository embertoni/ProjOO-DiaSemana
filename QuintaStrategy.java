public class QuintaStrategy extends StrategyBase {
    public QuintaStrategy() {
        super(DiaSemana.QUINTA, Prioridade.MEDIA);
    }

    @Override
    protected String criarMensagem(ContextoExecucao contexto) {
        return "Olá, " + contexto.getUsuario()
                + ". Quinta-feira é dia de colaboração. Compartilhe ou peça ajuda sobre: \""
                + contexto.getInformacaoAdicional() + "\".";
    }
}
