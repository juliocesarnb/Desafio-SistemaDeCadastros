// Main.java
import Controller.PetController;
import View.MenuView;
import View.MensagemView;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MenuView menuView = new MenuView(scanner);
        PetController petController = new PetController(scanner);

        int opcao;

        do {
            opcao = menuView.exibirMenuPrincipal();

            switch (opcao) {
                case 1:
                    petController.cadastrarNovoPet();
                    break;
                case 2:
                    petController.buscarPet();
                    break;
                case 3:
                    petController.alterarPet();
                    break;
                case 4:
                    petController.deletarPet();
                    break;
                case 5:
                    petController.listarTodosPets();
                    break;
                case 6:
                    MensagemView.sucesso("Sistema encerrado!");
                    break;
                default:
                    MensagemView.erro("Opção inválida!");
            }

        } while (opcao != 6);

        scanner.close();
    }
}