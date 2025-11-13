// MenuView.java
package View;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int exibirMenuPrincipal() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE ADOÇÃO DE PETS              ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("1 - Cadastrar um novo pet");
        System.out.println("2 - Buscar dados do pet cadastrado");
        System.out.println("3 - Alterar os dados do pet");
        System.out.println("4 - Deletar um pet cadastrado");
        System.out.println("5 - Listar todos os pets cadastrados");
        System.out.println("6 - Sair");
        System.out.println("─────────────────────────────────────────");

        return lerOpcaoValida();
    }

    private int lerOpcaoValida() {
        while (true) {
            try {
                System.out.print("Escolha uma opção: ");
                int opcao = Integer.parseInt(scanner.nextLine());

                if (opcao <= 0) {
                    MensagemView.erro("Digite um número positivo!");
                    continue;
                }

                if (opcao > 6) {
                    MensagemView.erro("Digite um número de 1 a 6!");
                    continue;
                }

                return opcao;

            } catch (NumberFormatException e) {
                MensagemView.erro("Digite apenas números!");
            }
        }
    }
}