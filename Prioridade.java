public enum Prioridade {
    ALTA("ALTA"),
    MEDIA("MÉDIA"),
    BAIXA("BAIXA");

    private final String descricao;

    Prioridade(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
