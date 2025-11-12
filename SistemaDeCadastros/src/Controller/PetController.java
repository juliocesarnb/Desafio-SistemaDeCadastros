package Controller;

import Model.Pet;
import Service.PetStorage;
import View.MenuView;
import View.PetRegisterView;
import java.util.Scanner;

import static View.PetCriterionView.displayCriterioList;
import static View.PetListView.displayList;

public class PetController {

    public static void cadastrarPet() {
        Pet novoPet = PetRegisterView.exibirFormulario();

        if (novoPet != null) {
            boolean sucesso = PetStorage.salvar(novoPet);
            System.out.println(sucesso ? "✓ Pet cadastrado!" : "✗ Erro ao cadastrar");
        }
    }

    public static void iniciarSistema() {
        MenuView.exibirMensagem("Bem-vindo ao Sistema de Cadastro de Pets!");

        while (true) {
            MenuView.exibirMenu();
            int opcao = MenuView.coletarOpcao();

            switch (opcao) {
                case 1:
                    processarCadastro();
                    break;
                case 2:
                    processarAlteracao();
                    break;
                case 3:
                    processarDelecao();
                    break;
                case 4:
                    processarListagemCompleta();
                    break;
                case 5:
                    processarListagemCriterio();
                    break;
                case 6:
                    MenuView.exibirMensagem("Obrigado por usar o sistema! Até logo!");
                    return; // Sai do loop
                default:
                    // A validação já garante que não chega aqui
                    MenuView.exibirMensagem("Opção inválida. Tente novamente.");
            }

            // Pausa antes do próximo menu
            System.out.println("\nPressione Enter para continuar...");
            try {
                System.in.read(); // Pausa simples
            } catch (Exception e) {
                // Ignora erro
            }
        }
    }

    private static void processarDelecao() {
    }
    private static void processarAlteracao() {
        System.out.println("Você quer listar todos os pets? Se SIM, aperte 1 ou 2 para listar por algum critério");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            displayList();
        }
        else if (opcao == 2) {
            displayCriterioList();
        }
        else {
            System.out.println("Erro");
        }
    }
    private static void processarListagemCompleta(){

    }
    private static void processarListagemCriterio(){
            
    }

    private static void processarCadastro() {
        Pet novoPet = PetRegisterView.exibirFormulario();

        if (novoPet != null) {
            // Chama o Service para validar e salvar
            boolean sucesso = PetStorage.salvar(novoPet);

            if (sucesso) {
                System.out.println("\n✓ Pet cadastrado com sucesso!");
            } else {
                System.out.println("\n✗ Erro ao salvar o pet no arquivo.");
            }
        } else {
            System.out.println("\n✗ Não foi possível criar o pet. Verifique os dados.");
        }
    }

}


