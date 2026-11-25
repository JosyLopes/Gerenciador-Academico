public class ListaAlunos {
    private NoAluno inicio;
    private int tamanho;

    public ListaAlunos() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void adicionar(Aluno aluno) {
        NoAluno novo = new NoAluno(aluno);
        if (inicio == null) {
            inicio = novo;
        } else {
            NoAluno atual = inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novo);
        }
        tamanho++;
    }

    public Aluno buscar(int matricula) {
        NoAluno atual = inicio;
        while (atual != null) {
            if (atual.getAluno().getMatricula() == matricula) {
                return atual.getAluno();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public boolean remover(int matricula) {
        NoAluno atual = inicio;
        NoAluno anterior = null;
        while (atual != null) {
            if (atual.getAluno().getMatricula() == matricula) {
                if (anterior == null) {
                    inicio = atual.getProximo();
                } else {
                    anterior.setProximo(atual.getProximo());
                }
                tamanho--;
                return true;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        return false;
    }

    public void listar() {
        if (inicio == null) {
            System.out.println("   (nenhum aluno matriculado)");
            return;
        }
        NoAluno atual = inicio;
        int posicao = 1;
        while (atual != null) {
            System.out.println("   " + posicao + ". " + atual.getAluno());
            atual = atual.getProximo();
            posicao++;
        }
    }

    public int getTamanho() {
        return tamanho;
    }
}
