import java.text.Normalizer;
import java.time.DayOfWeek;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public enum DiaSemana {
    SEGUNDA(DayOfWeek.MONDAY, "segunda-feira", "segunda"),
    TERCA(DayOfWeek.TUESDAY, "terça-feira", "terça", "terca-feira", "terca"),
    QUARTA(DayOfWeek.WEDNESDAY, "quarta-feira", "quarta"),
    QUINTA(DayOfWeek.THURSDAY, "quinta-feira", "quinta"),
    SEXTA(DayOfWeek.FRIDAY, "sexta-feira", "sexta"),
    SABADO(DayOfWeek.SATURDAY, "sábado", "sabado"),
    DOMINGO(DayOfWeek.SUNDAY, "domingo");

    private final DayOfWeek dayOfWeek;
    private final String nomeExibicao;
    private final String[] aliases;

    private static final Map<DayOfWeek, DiaSemana> POR_DAY_OF_WEEK;
    private static final Map<String, DiaSemana> POR_TEXTO;

    static {
        Map<DayOfWeek, DiaSemana> porDayOfWeek = new HashMap<>();
        Map<String, DiaSemana> porTexto = new HashMap<>();

        for (DiaSemana dia : values()) {
            porDayOfWeek.put(dia.dayOfWeek, dia);
            porTexto.put(normalizar(dia.nomeExibicao), dia);
            for (String alias : dia.aliases) {
                porTexto.put(normalizar(alias), dia);
            }
        }

        POR_DAY_OF_WEEK = Collections.unmodifiableMap(porDayOfWeek);
        POR_TEXTO = Collections.unmodifiableMap(porTexto);
    }

    DiaSemana(DayOfWeek dayOfWeek, String nomeExibicao, String... aliases) {
        this.dayOfWeek = dayOfWeek;
        this.nomeExibicao = nomeExibicao;
        this.aliases = aliases;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public static DiaSemana fromDayOfWeek(DayOfWeek dayOfWeek) {
        return POR_DAY_OF_WEEK.get(dayOfWeek);
    }

    public static Optional<DiaSemana> fromTexto(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(POR_TEXTO.get(normalizar(texto)));
    }

    private static String normalizar(String texto) {
        String semAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        return semAcentos
                .toLowerCase(Locale.ROOT)
                .trim()
                .replace('_', '-')
                .replace(' ', '-');
    }
}
