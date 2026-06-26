public class SegundaStrategy extends StrategyBase {
    public SegundaStrategy() {
        super(DiaSemana.SEGUNDA, Prioridade.ALTA);
    }

    @Override
    protected String criarMensagem(ContextoExecucao contexto) {
        return "Olá, " + contexto.getUsuario()
                + ". Segunda-feira é dia de organizar prioridades. Comece por: \""
                + contexto.getInformacaoAdicional() + "\".";
    }
}
