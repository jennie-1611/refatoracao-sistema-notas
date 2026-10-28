import java.util.List;

public class MySQLNotaRepository implements NotaRepository {
    @Override
    public void salvar(String matricula, List<Double> notas) {
        // Simulação: não é aberta uma conexão real com o banco.
        System.out.println(
            "Simulação: notas do aluno " + matricula +
            " salvas no MySQL: " + notas
        );
    }
}
