public class ArvoreCursos {
    private NoCurso raiz;

    public ArvoreCursos() {
        this.raiz = null;
    }

    public boolean inserir(Curso curso) {
        if (buscar(curso.getCodigo()) != null) {
            return false;
        }
        raiz = inserir(raiz, curso);
        return true;
    }

    private NoCurso inserir(NoCurso no, Curso curso) {
        if (no == null) {
            return new NoCurso(curso);
        }
        if (curso.getCodigo() < no.getCurso().getCodigo()) {
            no.setEsquerda(inserir(no.getEsquerda(), curso));
        } else {
            no.setDireita(inserir(no.getDireita(), curso));
        }
        return no;
    }

    public Curso buscar(int codigo) {
        NoCurso atual = raiz;
        while (atual != null) {
            if (codigo == atual.getCurso().getCodigo()) {
                return atual.getCurso();
            }
            if (codigo < atual.getCurso().getCodigo()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }
        return null;
    }

    public boolean remover(int codigo) {
        if (buscar(codigo) == null) {
            return false;
        }
        raiz = remover(raiz, codigo);
        return true;
    }

    private NoCurso remover(NoCurso no, int codigo) {
        if (no == null) {
            return null;
        }
        if (codigo < no.getCurso().getCodigo()) {
            no.setEsquerda(remover(no.getEsquerda(), codigo));
        } else if (codigo > no.getCurso().getCodigo()) {
            no.setDireita(remover(no.getDireita(), codigo));
        } else {
            if (no.getEsquerda() == null) {
                return no.getDireita();
            }
            if (no.getDireita() == null) {
                return no.getEsquerda();
            }
            NoCurso sucessor = no.getDireita();
            while (sucessor.getEsquerda() != null) {
                sucessor = sucessor.getEsquerda();
            }
            no.setCurso(sucessor.getCurso());
            no.setDireita(remover(no.getDireita(), sucessor.getCurso().getCodigo()));
        }
        return no;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public void emOrdem() {
        emOrdem(raiz);
    }

    private void emOrdem(NoCurso no) {
        if (no != null) {
            emOrdem(no.getEsquerda());
            System.out.println(no.getCurso());
            emOrdem(no.getDireita());
        }
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    private void preOrdem(NoCurso no) {
        if (no != null) {
            System.out.println(no.getCurso());
            preOrdem(no.getEsquerda());
            preOrdem(no.getDireita());
        }
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    private void posOrdem(NoCurso no) {
        if (no != null) {
            posOrdem(no.getEsquerda());
            posOrdem(no.getDireita());
            System.out.println(no.getCurso());
        }
    }
}
