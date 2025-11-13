package View;

import Model.*;
import Exception.DadosInvalidosException;
import Util.Constantes;
import Util.ValidadorUtil;

import java.util.Scanner;

public class CadastroView {
    private final FormularioView formularioView;
    private Scanner scanner;

    public CadastroView(Scanner scanner) {
        this.scanner = scanner;
        this.formularioView = new FormularioView();
        try {
            this.formularioView.leitorDeFormulario();
        } catch (Exception e) {
            System.err.println("Erro crítico ao carregar as perguntas do formulário: " + e.getMessage());
        }
    }

   // metodo para usar o metodo leitorDeFormulario da classe FormularioView
    private String obterPerguntaNomeCompleto() {
        return this.formularioView.getPerguntaNomeCompleto();
    }
    private String obterPerguntaTipo() {
        return this.formularioView.getPerguntaTipo();
    }
    private String obterPerguntaSexo() {
        return  this.formularioView.getPerguntaSexo();
    }
    private String obterPerguntaEndereco() {
        return this.formularioView.getPerguntaEndereco();
    }
    private String obterPerguntaIdade() {
        return this.formularioView.getPerguntaIdade();
    }
    private String obterPerguntaPeso() {
        return this.formularioView.getPerguntaPeso();
    }
    private String obterPerguntaRaca() {
        return this.formularioView.getPerguntaRaca();
    }


    public Pet coletarDadosPet() throws DadosInvalidosException {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      CADASTRO DE NOVO PET               ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        Pet pet = new Pet();

        // 1 - Nome e sobrenome
        lerNomeESobrenome(pet);

        // 2 - Tipo
        lerTipo(pet);

        // 3 - Sexo
        lerSexo(pet);

        // 4 - Endereço
        lerEndereco(pet);

        // 5 - Idade
        lerIdade(pet);

        // 6 - Peso
        lerPeso(pet);

        // 7 - Raça
        lerRaca(pet);

        return pet;
    }

    private void lerNomeESobrenome(Pet pet) throws DadosInvalidosException {
        System.out.println(obterPerguntaNomeCompleto());
        System.out.print("Resposta: ");
        String nomeCompleto = scanner.nextLine().trim();

        if (nomeCompleto.isEmpty()) {
            throw new DadosInvalidosException("Nome e sobrenome são obrigatórios!");
        }

        if (!ValidadorUtil.validarNomeApenasLetras(nomeCompleto)) {
            throw new DadosInvalidosException("Nome só pode conter letras!");
        }

        if (!ValidadorUtil.temNomeESobrenome(nomeCompleto)) {
            throw new DadosInvalidosException("Informe nome e sobrenome!");
        }

        String[] partes = nomeCompleto.split(" ", 2);
        pet.setNome(partes[0]);
        pet.setSobrenome(partes[1]);
        pet.setNomeCompleto(nomeCompleto);
    }

    private void lerTipo(Pet pet) throws DadosInvalidosException {
        System.out.println(obterPerguntaTipo());
        System.out.print("Resposta: ");
        String tipoStr = scanner.nextLine().trim().toUpperCase();

        if (tipoStr.equals("CACHORRO")) {
            pet.setTipo(TipoPet.CACHORRO);
        } else if (tipoStr.equals("GATO")) {
            pet.setTipo(TipoPet.GATO);
        } else {
            throw new DadosInvalidosException("Tipo inválido! Digite CACHORRO ou GATO.");
        }
    }

    private void lerSexo(Pet pet) throws DadosInvalidosException {
        System.out.println(obterPerguntaSexo());
        System.out.print("Resposta (Macho/Femea): ");
        String sexoStr = scanner.nextLine().trim().toUpperCase();

        if (sexoStr.equals("MACHO")) {
            pet.setSexo(SexoPet.MACHO);
        } else if (sexoStr.equals("FEMEA") || sexoStr.equals("FÊMEA")) {
            pet.setSexo(SexoPet.FEMEA);
        } else {
            throw new DadosInvalidosException("Sexo inválido! Digite MACHO ou FEMEA.");
        }
    }

    private void lerEndereco(Pet pet) {
        System.out.println(obterPerguntaEndereco());

        System.out.print("Rua: ");
        String rua = scanner.nextLine().trim();
        if (rua.isEmpty()) rua = Constantes.NAO_INFORMADO;

        System.out.print("Número: ");
        String numero = scanner.nextLine().trim();
        if (numero.isEmpty()) numero = Constantes.NAO_INFORMADO;

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine().trim();
        if (cidade.isEmpty()) cidade = Constantes.NAO_INFORMADO;

        Endereco endereco = new Endereco(rua, numero, cidade);
        pet.setEndereco(endereco);
    }

    private void lerIdade(Pet pet) throws DadosInvalidosException {
        System.out.println(obterPerguntaIdade());
        System.out.print("Resposta (em anos): ");
        String idadeStr = scanner.nextLine().trim();

        if (idadeStr.isEmpty()) {
            pet.setIdade(0);
            return;
        }

        try {
            idadeStr = idadeStr.replace(",", ".");
            double idade = Double.parseDouble(idadeStr);

            ValidadorUtil.validarIdade(idade);
            pet.setIdade(idade);

        } catch (NumberFormatException e) {
            throw new DadosInvalidosException("Idade inválida! Digite apenas números.");
        }
    }

    private void lerPeso(Pet pet) throws DadosInvalidosException {
        System.out.println(obterPerguntaPeso());
        System.out.print("Resposta (em kg): ");
        String pesoStr = scanner.nextLine().trim();

        if (pesoStr.isEmpty()) {
            pet.setPeso(0);
            return;
        }

        try {
            pesoStr = pesoStr.replace(",", ".");
            double peso = Double.parseDouble(pesoStr);

            ValidadorUtil.validarPeso(peso);
            pet.setPeso(peso);

        } catch (NumberFormatException e) {
            throw new DadosInvalidosException("Peso inválido! Digite apenas números.");
        }
    }

    private void lerRaca(Pet pet) throws DadosInvalidosException {
        System.out.println(obterPerguntaRaca());
        System.out.print("Resposta: ");
        String raca = scanner.nextLine().trim();

        if (raca.isEmpty()) {
            pet.setRaca(Constantes.NAO_INFORMADO);
            return;
        }

        if (!ValidadorUtil.validarRacaApenasLetras(raca)) {
            throw new DadosInvalidosException("Raça não pode conter números!");
        }

        pet.setRaca(raca);
    }
}