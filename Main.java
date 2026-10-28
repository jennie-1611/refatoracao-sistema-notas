// Discente: JENNIFER SAMARA PONTES BARBOSA
public class Main {
    public static void main(String[] args) {
        GerenciadorNotas gerenciador = new GerenciadorNotas();

        gerenciador.adicionarNota(8.0);
        gerenciador.adicionarNota(9.0);
        gerenciador.adicionarNota(7.0);

        System.out.printf("Notas: %s%n", gerenciador.consultarNotas());
        System.out.printf("Média: %.2f%n", gerenciador.calcularMedia());

        try {
            gerenciador.adicionarNota(12.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Nota rejeitada: " + e.getMessage());
        }

        System.out.printf(
            "Notas após a tentativa inválida: %s%n",
            gerenciador.consultarNotas()
        );

        EmailService emailService = new EmailService();

        System.out.println("\n--- Usando repositório MySQL (simulado) ---");
        NotaService servicoMySQL = new NotaService(
            gerenciador,
            new MySQLNotaRepository(),
            emailService
        );
        servicoMySQL.salvarNotas("2026001");
        servicoMySQL.enviarMediaPorEmail("aluno@universidade.edu.br");

        System.out.println("\n--- Trocando para outro repositório ---");
        NotaService servicoAlternativo = new NotaService(
            gerenciador,
            new MemoriaNotaRepository(),
            emailService
        );
        servicoAlternativo.salvarNotas("2026001");
        servicoAlternativo.enviarMediaPorEmail("aluno@universidade.edu.br");

        GerenciadorNotas vazio = new GerenciadorNotas();
        System.out.printf(
            "%nMédia sem notas: %.2f%n",
            vazio.calcularMedia()
        );
    }
}
