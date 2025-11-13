// PetController.java
package Controller;

import Model.Pet;
import View.BuscaView;
import View.CadastroView;
import View.MensagemView;
import repository.PetRepository;
import Exception.DadosInvalidosException;

import java.util.Scanner;

public class PetController {
    private CadastroView cadastroView;
    private PetRepository petRepository;

    public PetController(Scanner scanner) {
        this.cadastroView = new CadastroView(scanner);
        this.petRepository = new PetRepository();
    }

    public void cadastrarNovoPet() {
        try {
            // VIEW coleta os dados
            Pet pet = cadastroView.coletarDadosPet();

            // REPOSITORY salva
            petRepository.salvar(pet);

            // VIEW exibe mensagem
            MensagemView.sucesso("Pet cadastrado com sucesso!");

        } catch (DadosInvalidosException e) {
            MensagemView.erro(e.getMessage());
            MensagemView.info("Cadastro cancelado.");
        }
    }

    public void buscarPet() {
        BuscaView.displayList();
//        MensagemView.info("Funcionalidade em desenvolvimento...");
    }

    public void alterarPet() {
        MensagemView.info("Funcionalidade em desenvolvimento...");
    }

    public void deletarPet() {
        MensagemView.info("Funcionalidade em desenvolvimento...");
    }

    public void listarTodosPets() {
        MensagemView.info("Funcionalidade em desenvolvimento...");
    }
}