import java.util.List;

public class MemoriaNotaRepository implements NotaRepository {
    @Override
    public void salvar(String matricula, List<Double> notas) {
        // Implementação alternativa para demonstrar a troca do repositório.
        System.out.println(
            "Simulação: notas do aluno " + matricula +
            " salvas em um repositório alternativo: " + notas
        );
    }
}
