public class DomingoStrategy extends StrategyBase {
    public DomingoStrategy() {
        super(DiaSemana.DOMINGO, Prioridade.MEDIA);
    }

    @Override
    protected String criarMensagem(ContextoExecucao contexto) {
        return "Olá, " + contexto.getUsuario()
                + ". Domingo é dia de planejar a próxima semana. Defina como meta: \""
                + contexto.getInformacaoAdicional() + "\".";
    }
}
