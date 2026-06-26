public abstract class StrategyBase implements StrategyDia {
    private final DiaSemana dia;
    private final Prioridade prioridade;

    protected StrategyBase(DiaSemana dia, Prioridade prioridade) {
        this.dia = dia;
        this.prioridade = prioridade;
    }

    @Override
    public ResultadoStrategy executar(ContextoExecucao contexto) {
        return new ResultadoStrategy(
                dia.getNomeExibicao(),
                prioridade,
                criarMensagem(contexto)
        );
    }

    protected abstract String criarMensagem(ContextoExecucao contexto);
}
