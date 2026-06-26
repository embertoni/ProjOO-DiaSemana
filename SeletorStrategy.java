import java.util.EnumMap;
import java.util.Map;

public class SeletorStrategy {
    private final Map<DiaSemana, StrategyDia> estrategias;
    private final StrategyDia estrategiaAusente;

    public SeletorStrategy() {
        this.estrategias = new EnumMap<>(DiaSemana.class);
        this.estrategiaAusente = new StrategyAusente();
        registrarEstrategiasPadrao();
    }

    public StrategyDia selecionar(DiaSemana dia) {
        return estrategias.getOrDefault(dia, estrategiaAusente);
    }

    private void registrarEstrategiasPadrao() {
        estrategias.put(DiaSemana.SEGUNDA, new SegundaStrategy());
        estrategias.put(DiaSemana.TERCA, new TercaStrategy());
        estrategias.put(DiaSemana.QUARTA, new QuartaStrategy());
        estrategias.put(DiaSemana.QUINTA, new QuintaStrategy());
        estrategias.put(DiaSemana.SEXTA, new SextaStrategy());
        estrategias.put(DiaSemana.SABADO, new SabadoStrategy());
        estrategias.put(DiaSemana.DOMINGO, new DomingoStrategy());
    }
}
