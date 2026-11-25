public class Curso {
    private int codigo;
    private String nome;
    private int vagas;
    private ListaAlunos matriculados;
    private FilaEspera filaEspera;

    public Curso(int codigo, String nome, int vagas) {
        this.codigo = codigo;
        this.nome = nome;
        this.vagas = vagas;
        this.matriculados = new ListaAlunos();
        this.filaEspera = new FilaEspera();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getVagas() {
        return vagas;
    }

    public ListaAlunos getMatriculados() {
        return matriculados;
    }

    public FilaEspera getFilaEspera() {
        return filaEspera;
    }

    public String matricular(Aluno aluno) {
        if (matriculados.buscar(aluno.getMatricula()) != null) {
            return "Aluno ja matriculado neste curso.";
        }
        if (filaEspera.buscar(aluno.getMatricula()) != null) {
            return "Aluno ja esta na fila de espera deste curso.";
        }
        if (matriculados.getTamanho() < vagas) {
            matriculados.adicionar(aluno);
            return "Aluno matriculado com sucesso.";
        }
        filaEspera.adicionar(aluno);
        return "Curso sem vagas. Aluno adicionado a fila de espera.";
    }

    public String cancelarMatricula(int matricula) {
        if (matriculados.remover(matricula)) {
            Aluno proximo = filaEspera.remover();
            if (proximo != null) {
                matriculados.adicionar(proximo);
                return "Matricula cancelada. Aluno " + proximo.getNome() + " saiu da fila e foi matriculado.";
            }
            return "Matricula cancelada.";
        }
        if (filaEspera.remover(matricula)) {
            return "Aluno removido da fila de espera.";
        }
        return "Aluno nao encontrado neste curso.";
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " | Curso: " + nome + " | Vagas: " + matriculados.getTamanho() + "/" + vagas
                + " | Fila de espera: " + filaEspera.getTamanho();
    }
}
