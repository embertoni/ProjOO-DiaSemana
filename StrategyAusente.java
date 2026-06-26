package DiaSemana;

public class StrategyAusente implements StrategyDia {
    @Override
    public ResultadoStrategy executar(ContextoExecucao contexto) {
        return new ResultadoStrategy(
                contexto.getDiaInformado(),
                Prioridade.BAIXA,
                "Não existe estratégia associada ao dia informado. "
                        + "O programa continuará em execução de forma segura."
        );
    }
}
