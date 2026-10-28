import java.util.ArrayList;
import java.util.List;

public class GerenciadorNotas {
    private final List<Double> notas = new ArrayList<>();

    public void adicionarNota(double nota) {
        if (!Double.isFinite(nota) || nota < 0.0 || nota > 10.0) {
            throw new IllegalArgumentException(
                "A nota deve ser um número finito entre 0 e 10."
            );
        }
        notas.add(nota);
    }

    public List<Double> consultarNotas() {
        return List.copyOf(notas);
    }

    public double calcularMedia() {
        if (notas.isEmpty()) {
            return 0.0;
        }

        double soma = 0.0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }
}
