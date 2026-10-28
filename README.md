# Atividade prática — Refatoração do Sistema de Notas

## Discente
- JENNIFER SAMARA PONTES BARBOSA

## Descrição
O projeto refatora um sistema de notas, separando a gestão das notas, a persistência e o envio de e-mails. As operações de banco de dados e de e-mail são simuladas no console, conforme permitido no enunciado.

## Arquivos e responsabilidades
- `GerenciadorNotas.java`: mantém as notas privadas, valida valores e calcula a média.
- `NotaRepository.java`: define a interface para salvar notas.
- `MySQLNotaRepository.java`: implementação simulada do repositório MySQL.
- `MemoriaNotaRepository.java`: implementação alternativa para demonstrar a substituição da persistência.
- `EmailService.java`: simula o envio de e-mail.
- `NotaService.java`: coordena as operações e recebe o repositório pelo construtor usando a interface.
- `Main.java`: demonstra os requisitos da atividade.

## Como compilar e executar
É necessário ter o JDK instalado.

1. Abra a pasta do projeto no VS Code.
2. Abra o terminal integrado em **Terminal > Novo Terminal**.
3. Execute:

   ```bash
   javac *.java
   java Main
   ```

No Windows, os mesmos comandos funcionam no terminal do VS Code se o JDK estiver instalado e configurado no `PATH`.

## Como os três problemas foram resolvidos

### 1. Exposição dos dados e notas inválidas
A lista `notas` é `private` em `GerenciadorNotas`. As notas só entram pela função `adicionarNota`, que rejeita valores não finitos (como `NaN` e infinito) e valores menores que 0 ou maiores que 10, lançando `IllegalArgumentException`. O método `consultarNotas` devolve `List.copyOf(notas)`, uma cópia imutável, impedindo a alteração da coleção interna por quem consulta.

### 2. Acúmulo de responsabilidades
As tarefas foram separadas:
- `GerenciadorNotas`: adiciona, consulta e calcula a média.
- `NotaService`: coordena operações.
- `MySQLNotaRepository` e `MemoriaNotaRepository`: cuidam da persistência simulada.
- `EmailService`: cuida da simulação de envio de e-mail.

Cada classe tem uma responsabilidade mais específica, aplicando o princípio da responsabilidade única.

### 3. Dependência direta do MySQL
`NotaService` recebe um objeto do tipo `NotaRepository` no construtor, em vez de depender diretamente de `MySQLNotaRepository`. Assim, a implementação pode ser substituída por `MemoriaNotaRepository` sem alterar a classe `NotaService`, demonstrando inversão de dependências.

## Princípios de projeto aplicados
- **Ocultamento de informação:** a coleção interna é privada e só pode ser manipulada por métodos controlados.
- **Responsabilidade única:** gestão das notas, persistência, coordenação e envio de e-mail estão separados.
- **Inversão de dependências:** o serviço depende da abstração `NotaRepository`, não de uma implementação concreta.

## Demonstração esperada
O programa:
1. Adiciona as notas 8.0, 9.0 e 7.0 e mostra a média `8.00`.
2. Tenta adicionar 12.0, captura a exceção e mostra que a nota inválida não foi incluída.
3. Simula persistência e envio de e-mail.
4. Usa primeiro o repositório MySQL simulado e depois uma implementação alternativa, sem modificar `NotaService`.
5. Mostra que a média de uma lista vazia é `0.00`.
