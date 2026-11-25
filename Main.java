import java.util.Scanner;

public class Main {
    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        ArvoreCursos cursos = new ArvoreCursos();
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opcao: ");
            System.out.println();
            executar(opcao, cursos);
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n===== SISTEMA DE GESTAO ACADEMICA =====");
        System.out.println("1 - Cadastrar curso");
        System.out.println("2 - Buscar curso por codigo");
        System.out.println("3 - Remover curso");
        System.out.println("4 - Listar cursos (in-ordem, pre-ordem, pos-ordem)");
        System.out.println("5 - Matricular aluno em curso");
        System.out.println("6 - Cancelar matricula / sair da fila");
        System.out.println("7 - Listar alunos matriculados de um curso");
        System.out.println("8 - Listar fila de espera de um curso");
        System.out.println("0 - Sair");
    }

    private static void executar(int opcao, ArvoreCursos cursos) {
        switch (opcao) {
            case 1:
                cadastrarCurso(cursos);
                break;
            case 2:
                buscarCurso(cursos);
                break;
            case 3:
                removerCurso(cursos);
                break;
            case 4:
                listarCursos(cursos);
                break;
            case 5:
                matricularAluno(cursos);
                break;
            case 6:
                cancelarMatricula(cursos);
                break;
            case 7:
                listarMatriculados(cursos);
                break;
            case 8:
                listarFila(cursos);
                break;
            case 0:
                System.out.println("Encerrando o sistema.");
                break;
            default:
                System.out.println("Opcao invalida.");
        }
    }

    private static void cadastrarCurso(ArvoreCursos cursos) {
        int codigo = lerInteiro("Codigo do curso: ");
        String nome = lerTexto("Nome do curso: ");
        int vagas = lerInteiro("Numero de vagas: ");
        if (vagas <= 0) {
            System.out.println("O numero de vagas deve ser maior que zero.");
            return;
        }
        if (cursos.inserir(new Curso(codigo, nome, vagas))) {
            System.out.println("Curso cadastrado com sucesso.");
        } else {
            System.out.println("Ja existe um curso com esse codigo.");
        }
    }

    private static void buscarCurso(ArvoreCursos cursos) {
        Curso curso = cursos.buscar(lerInteiro("Codigo do curso: "));
        if (curso == null) {
            System.out.println("Curso nao encontrado.");
        } else {
            System.out.println(curso);
        }
    }

    private static void removerCurso(ArvoreCursos cursos) {
        if (cursos.remover(lerInteiro("Codigo do curso: "))) {
            System.out.println("Curso removido com sucesso.");
        } else {
            System.out.println("Curso nao encontrado.");
        }
    }

    private static void listarCursos(ArvoreCursos cursos) {
        if (cursos.estaVazia()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }
        System.out.println("--- Em ordem ---");
        cursos.emOrdem();
        System.out.println("--- Pre-ordem ---");
        cursos.preOrdem();
        System.out.println("--- Pos-ordem ---");
        cursos.posOrdem();
    }

    private static void matricularAluno(ArvoreCursos cursos) {
        Curso curso = cursos.buscar(lerInteiro("Codigo do curso: "));
        if (curso == null) {
            System.out.println("Curso nao encontrado.");
            return;
        }
        int matricula = lerInteiro("Matricula do aluno: ");
        String nome = lerTexto("Nome do aluno: ");
        System.out.println(curso.matricular(new Aluno(matricula, nome)));
    }

    private static void cancelarMatricula(ArvoreCursos cursos) {
        Curso curso = cursos.buscar(lerInteiro("Codigo do curso: "));
        if (curso == null) {
            System.out.println("Curso nao encontrado.");
            return;
        }
        System.out.println(curso.cancelarMatricula(lerInteiro("Matricula do aluno: ")));
    }

    private static void listarMatriculados(ArvoreCursos cursos) {
        Curso curso = cursos.buscar(lerInteiro("Codigo do curso: "));
        if (curso == null) {
            System.out.println("Curso nao encontrado.");
            return;
        }
        System.out.println("Alunos matriculados em " + curso.getNome() + ":");
        curso.getMatriculados().listar();
    }

    private static void listarFila(ArvoreCursos cursos) {
        Curso curso = cursos.buscar(lerInteiro("Codigo do curso: "));
        if (curso == null) {
            System.out.println("Curso nao encontrado.");
            return;
        }
        System.out.println("Fila de espera de " + curso.getNome() + ":");
        curso.getFilaEspera().listar();
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = entrada.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return entrada.nextLine().trim();
    }
}
