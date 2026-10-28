public class EmailService {
    public void enviarEmail(String destinatario, double media) {
        // Simulação: nenhum e-mail real é enviado.
        System.out.println(
            "Simulação: e-mail enviado para " + destinatario +
            " com a média " + String.format("%.2f", media)
        );
    }
}
