import java.util.List;

public interface NotaRepository {
    void salvar(String matricula, List<Double> notas);
}
