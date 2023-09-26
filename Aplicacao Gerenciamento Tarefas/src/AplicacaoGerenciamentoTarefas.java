import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean estaConcluida() {
        return concluida;
    }

    public void marcarConcluida() {
        concluida = true;
    }

    @Override
    public String toString() {
        String status = concluida ? "[Concluída]" : "[Pendente]";
        return status + " " + descricao;
    }
}

class GerenciadorTarefas {
    private ArrayList<Tarefa> tarefas;

    public GerenciadorTarefas() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa tarefa = new Tarefa(descricao);
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            System.out.println("Lista de Tarefas:");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    public void marcarTarefaConcluida(int indice) {
        if (indice >= 1 && indice <= tarefas.size()) {
            Tarefa tarefa = tarefas.get(indice - 1);
            tarefa.marcarConcluida();
            System.out.println("Tarefa marcada como concluída: " + tarefa.getDescricao());
        } else {
            System.out.println("Índice inválido.");
        }
    }
}

public class AplicacaoGerenciamentoTarefas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        while (true) {
            System.out.println("\n==== Gerenciador de Tarefas ====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    gerenciador.adicionarTarefa(descricao);
                    break;
                case 2:
                    gerenciador.listarTarefas();
                    break;
                case 3:
                    System.out.print("Digite o número da tarefa a ser marcada como concluída: ");
                    int indice = scanner.nextInt();
                    scanner.nextLine(); // Limpar a quebra de linha
                    gerenciador.marcarTarefaConcluida(indice);
                    break;
                case 4:
                    System.out.println("Saindo do programa. Até mais!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}

