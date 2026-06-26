public class ContextoExecucao {
    private final String usuario;
    private final String informacaoAdicional;
    private final String diaInformado;
    private final DiaSemana diaResolvido;

    public ContextoExecucao(String usuario, String informacaoAdicional, String diaInformado, DiaSemana diaResolvido) {
        this.usuario = textoOuPadrao(usuario, "usuário");
        this.informacaoAdicional = textoOuPadrao(informacaoAdicional, "nenhuma informação adicional informada");
        this.diaInformado = textoOuPadrao(diaInformado, "dia atual");
        this.diaResolvido = diaResolvido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getInformacaoAdicional() {
        return informacaoAdicional;
    }

    public String getDiaInformado() {
        return diaInformado;
    }

    public DiaSemana getDiaResolvido() {
        return diaResolvido;
    }

    private static String textoOuPadrao(String texto, String padrao) {
        if (texto == null || texto.trim().isEmpty()) {
            return padrao;
        }
        return texto.trim();
    }
}
