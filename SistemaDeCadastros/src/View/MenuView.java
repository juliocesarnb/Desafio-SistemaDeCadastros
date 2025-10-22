package View;

import java.util.InputMismatchException;
import java.util.Scanner;
public class MenuView {

    // ********* METODO AUXILIAR PARA EEXIBIR O MENU ***********
    public static void exibirMenu() {
        System.out.println("\n-------------Menu Pet--------------");
        System.out.println("Cadastrar um Pet? [Digite 1]");
        System.out.println("Alterar os dados do pet cadastrado? [Digite 2]");
        System.out.println("Deletar um pet cadastrado? [Digite 3]");
        System.out.println("Listar todos os pets cadastrados? [Digite 4]");
        System.out.println("Listar pets por algum critério (idade, nome, raça)? [Digite 5]");
        System.out.println("Sair? [Digite 6]");
        System.out.print("Escolha uma opção: ");
    }
    // ********* MAIN PARA INTERAÇÃO COM O USUÁRIO ***********
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        boolean entradaValida = false;

        // ******* Exibe o menu pela primeira vez ********
        exibirMenu();

        // ********* Loop de validação: continua enquanto a entrada não for válida **********
        while (!entradaValida) {
            try {
                // ********* Tenta ler o número *********
                opcao = scanner.nextInt();

                // ************** Verifica se a opção está no intervalo de 1 a 6 ***********
                if (opcao >= 1 && opcao <= 6) {
                    entradaValida = true; // A entrada é válida, sai do loop
                } else {
                    // ************* Se for um número fora do intervalo, exibe erro e reexibe o menu ********
                    System.out.println("\nOpção inválida (" + opcao + "). Digite um número de 1 a 6.");
                    exibirMenu();
                }

            } catch (InputMismatchException e) {
                // ************* Se não for um número (texto), exibe erro e reexibe o menu ************
                System.out.println("\nERRO: Por favor, digite apenas números inteiros.");
                scanner.nextLine(); // Limpa o buffer para evitar loop infinito
                exibirMenu(); // Reexibe o menu
            }
        } // Fim do loop de validação

        // A entrada é válida (1 a 6), agora processamos a escolha
        switch (opcao) {
            case 1:
                System.out.println("\n==> Opção 1 escolhida: Cadastrar Pet.");
                // Chamar lógica de cadastro
                FormularioView.exibirFormulario();

                break;
            case 2:
                System.out.println("\n==> Opção 2 escolhida: Alterar Pet.");
                // Chamar lógica de alteração
                break;
            case 3:
                System.out.println("\n==> Opção 3 escolhida: Deletar Pet.");
                // Chamar lógica de exclusão
                break;
            case 4:
                System.out.println("\n==> Opção 4 escolhida: Listar Todos os Pets.");
                // Chamar lógica de listagem
                break;
            case 5:
                System.out.println("\n==> Opção 5 escolhida: Listar Pets por Critério.");
                // Chamar lógica de critério
                break;
            case 6:
                System.out.println("\nSaindo do Menu Pet. Até logo!");
                break;
            // O caso 'default' não deve ser atingido devido ao loop de validação
            default:
                throw new IllegalStateException("Unexpected value: " + opcao);
        }

        scanner.close();
    }
}