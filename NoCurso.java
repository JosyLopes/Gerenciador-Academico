public class NoCurso {
    private Curso curso;
    private NoCurso esquerda;
    private NoCurso direita;

    public NoCurso(Curso curso) {
        this.curso = curso;
        this.esquerda = null;
        this.direita = null;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public NoCurso getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoCurso esquerda) {
        this.esquerda = esquerda;
    }

    public NoCurso getDireita() {
        return direita;
    }

    public void setDireita(NoCurso direita) {
        this.direita = direita;
    }
}
