public class SextaStrategy extends StrategyBase {
    public SextaStrategy() {
        super(DiaSemana.SEXTA, Prioridade.ALTA);
    }

    @Override
    protected String criarMensagem(ContextoExecucao contexto) {
        return "Olá, " + contexto.getUsuario()
                + ". Sexta-feira é dia de registrar o que foi concluído. Anote o progresso em: \""
                + contexto.getInformacaoAdicional() + "\".";
    }
}
