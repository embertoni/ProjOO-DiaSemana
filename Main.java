package DiaSemana;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SeletorStrategy seletor = new SeletorStrategy();

        DiaSemana diaAtual = DiaSemana.fromDayOfWeek(LocalDate.now().getDayOfWeek());

        System.out.println("=== Comportamento por Dia da Semana ===");
        System.out.println("Dia atual identificado pelo sistema: " + diaAtual.getNomeExibicao());
        System.out.println(); 

        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Informe uma tarefa, meta ou informação adicional: ");
        String informacaoAdicional = scanner.nextLine();

        System.out.print("Dia para consultar (pressione ENTER para usar o dia atual): ");
        String diaInformado = scanner.nextLine();

        DiaSemana diaResolvido = resolverDiaConsultado(diaInformado, diaAtual);
        String diaFinal;

        if (diaInformado.trim().isEmpty()) {
            diaFinal = diaAtual.getNomeExibicao();
        } 
        else {
            diaFinal = diaInformado;
        }

        ContextoExecucao contexto = new ContextoExecucao(
                usuario,
                informacaoAdicional,
                diaFinal,
                diaResolvido
        );

        ResultadoStrategy resultado = seletor
                .selecionar(contexto.getDiaResolvido())
                .executar(contexto);

        System.out.println();
        System.out.println("Usuário: " + contexto.getUsuario());
        System.out.println("Dia consultado: " + resultado.getDiaConsultado());
        System.out.println("Prioridade: " + resultado.getPrioridade());
        System.out.println("Mensagem: " + resultado.getMensagem());

        scanner.close();
    }

    private static DiaSemana resolverDiaConsultado(String diaInformado, DiaSemana diaAtual) {
        if (diaInformado == null || diaInformado.trim().isEmpty()) {
            return diaAtual;
        }

        Optional<DiaSemana> diaManual = DiaSemana.fromTexto(diaInformado);
        return diaManual.orElse(null);
    }
}
