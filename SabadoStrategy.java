package DiaSemana;

public class SabadoStrategy extends StrategyBase {
    public SabadoStrategy() {
        super(DiaSemana.SABADO, Prioridade.BAIXA);
    }

    @Override
    protected String criarMensagem(ContextoExecucao contexto) {
        return "Olá, " + contexto.getUsuario()
                + ". Sábado combina com estudo livre ou descanso. Use esse tempo para: \""
                + contexto.getInformacaoAdicional() + "\".";
    }
}
