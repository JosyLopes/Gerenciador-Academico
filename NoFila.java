public class NoFila {
    private Aluno aluno;
    private NoFila proximo;

    public NoFila(Aluno aluno) {
        this.aluno = aluno;
        this.proximo = null;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public NoFila getProximo() {
        return proximo;
    }

    public void setProximo(NoFila proximo) {
        this.proximo = proximo;
    }
}
