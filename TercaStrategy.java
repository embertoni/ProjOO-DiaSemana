public class TercaStrategy extends StrategyBase {
    public TercaStrategy() {
        super(DiaSemana.TERCA, Prioridade.ALTA);
    }

    @Override
    protected String criarMensagem(ContextoExecucao contexto) {
        return "Olá, " + contexto.getUsuario()
                + ". Terça-feira é dia de avançar nas tarefas pendentes. Foque em: \""
                + contexto.getInformacaoAdicional() + "\".";
    }
}
