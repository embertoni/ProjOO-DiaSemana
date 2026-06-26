# Comportamento por Dia da Semana

**Resolução do Exercício Prático de ProjOO - 26/06**

O programa identifica o dia atual da semana usando `LocalDate.now()`, permite consultar manualmente um dia informado pelo usuário e delega a execução do comportamento para uma estratégia específica de cada dia.

## Requisitos atendidos

- Identificação do dia atual usando recursos da linguagem.
- Uso de uma estratégia para cada dia da semana.
- Cada estratégia recebe uma informação adicional digitada pelo usuário.
- Consulta manual de um dia, sem depender da data atual.
- Tratamento para entrada inválida ou ausência de estratégia.
- Cada estratégia retorna uma prioridade: ALTA, MÉDIA ou BAIXA.
- Uso de abstração de estratégia, estratégias concretas, estratégia segura para ausência de comportamento e seletor de estratégia.

## Como executar

Na pasta raiz do projeto, execute:

```bash
chcp 65001
$OutputEncoding = [System.Text.Encoding]::UTF8
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8
javac -encoding UTF-8 -d out *.java
java "-Dstdout.encoding=UTF-8" "-Dstdin.encoding=UTF-8" -cp out Main
```

## Questões de reflexão

1. Para evitar verificações repetidas de **null**, o componente responsável por selecionar a estratégia deve sempre retornar um objeto válido que implemente a mesma interface das demais estratégias.
Isso foi implementado na classe `SeletorStrategy`, que retorna uma estratégia concreta quando o dia existe ou retorna `StrategyAusente` quando o dia é inválido ou não possui comportamento associado.


2. O padrão utilizado é o **Null Object**. Ele permite representar a ausência de um comportamento por meio de um objeto real, com implementação segura, em vez de retornar `null`.


3. A incorporação ocorre através da classe `StrategyAusente`, que implementa a interface `StrategyDia`. Assim, todas as estratégias possuem o mesmo contrato:

    ```java
    ResultadoStrategy executar(ContextoExecucao contexto);
    ```
    Com isso, o programa principal apenas executa a estratégia retornada pelo seletor, sem precisar verificar se ela é nula.
    
    Além disso, a solução também usa o padrão **Strategy**, pois cada dia da semana possui uma classe responsável pelo seu próprio comportamento.


## Exemplos de execução

### - Válida:

Entrada:

```text
Usuário: Alpha
Informe uma tarefa, meta ou informação adicional: Implementar relatório
Dia para consultar: quarta-feira
```

Saída:

```text
Usuário: Alpha
Dia consultado: quarta-feira
Prioridade: MÉDIA
Mensagem: Dia de revisão: verifique o andamento da atividade "Implementar relatório".
```

### - Inválida:

Entrada:

```text
Usuário: Beta
Informe uma tarefa, meta ou informação adicional: Revisar código
Dia para consultar: feriado
```

Saída:

```text
Usuário: Beta
Dia consultado: feriado
Prioridade: BAIXA
Mensagem: Não existe estratégia associada ao dia informado. O programa continuará em execução de forma segura.
```
