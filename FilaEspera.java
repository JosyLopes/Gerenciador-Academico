public class FilaEspera {
    private NoFila inicio;
    private NoFila fim;
    private int tamanho;

    public FilaEspera() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void adicionar(Aluno aluno) {
        NoFila novo = new NoFila(aluno);
        if (fim == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProximo(novo);
            fim = novo;
        }
        tamanho++;
    }

    public Aluno remover() {
        if (inicio == null) {
            return null;
        }
        Aluno aluno = inicio.getAluno();
        inicio = inicio.getProximo();
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return aluno;
    }

    public boolean remover(int matricula) {
        NoFila atual = inicio;
        NoFila anterior = null;
        while (atual != null) {
            if (atual.getAluno().getMatricula() == matricula) {
                if (anterior == null) {
                    inicio = atual.getProximo();
                } else {
                    anterior.setProximo(atual.getProximo());
                }
                if (atual == fim) {
                    fim = anterior;
                }
                tamanho--;
                return true;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        return false;
    }

    public Aluno buscar(int matricula) {
        NoFila atual = inicio;
        while (atual != null) {
            if (atual.getAluno().getMatricula() == matricula) {
                return atual.getAluno();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void listar() {
        if (inicio == null) {
            System.out.println("   (fila de espera vazia)");
            return;
        }
        NoFila atual = inicio;
        int posicao = 1;
        while (atual != null) {
            System.out.println("   " + posicao + "o da fila - " + atual.getAluno());
            atual = atual.getProximo();
            posicao++;
        }
    }

    public int getTamanho() {
        return tamanho;
    }
}
