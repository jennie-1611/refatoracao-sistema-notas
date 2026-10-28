public class NotaService {
    private final GerenciadorNotas gerenciadorNotas;
    private final NotaRepository repositorio;
    private final EmailService emailService;

    public NotaService(
        GerenciadorNotas gerenciadorNotas,
        NotaRepository repositorio,
        EmailService emailService
    ) {
        this.gerenciadorNotas = gerenciadorNotas;
        this.repositorio = repositorio;
        this.emailService = emailService;
    }

    public void salvarNotas(String matricula) {
        repositorio.salvar(matricula, gerenciadorNotas.consultarNotas());
    }

    public void enviarMediaPorEmail(String destinatario) {
        emailService.enviarEmail(
            destinatario,
            gerenciadorNotas.calcularMedia()
        );
    }
}
