package View;

import java.util.Scanner;

public class MenuView {
    // Scanner reutilizável - nunca fechar!
    private static final Scanner scanner = new Scanner(System.in);

    public static void exibirMenu() {
        System.out.println("-----* MENU INICIAL DE CADASTRO DE PETS *-------");
        System.out.println("1. Cadastrar novo pet");
        System.out.println("2. Alterar os dados do pet cadastrado");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6. Sair");
        System.out.println("--------------------------------------");
    }

    public static int coletarOpcao() {
        while (true) {
            System.out.print("Digite a opção desejada: ");

            try {
                String input = scanner.nextLine().trim(); // Lê linha completa

                // Verifica se é número
                if (!input.matches("\\d+")) {
                    System.out.println("❌ Digite apenas números válidos!");
                    continue;
                }

                int opcao = Integer.parseInt(input);

                // Valida faixa (1-6)
                if (opcao >= 1 && opcao <= 6) {
                    return opcao;
                } else {
                    System.out.println("❌ Opção inválida! Digite entre 1 e 6.");
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida! Digite apenas números.");
            }
        }
    }

    public static void exibirMensagem(String mensagem) {
        System.out.println("\n" + mensagem + "\n");
    }
}
