package View;

import Model.Endereco;
import Model.Pet;
import Model.SexoPet;
import Model.TipoPet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

//*********** LÓGICA DE EXIBIÇÃO DE FORMULÁRIO ***************



public class FormularioView {

    // O metodo agora RETORNA um objeto Pet
    public static Pet exibirFormulario() {

        // Inicialização Variável local para leitura do usuário
        Scanner scanner = new Scanner(System.in);
        String nomePet = "";
        String sobrenomePet = "";
        TipoPet tipoPet = null;
        SexoPet sexoPet = null;
        int idadePet = 0;
        float pesoPet= 0.0F;
        String racaPet = "";
        Endereco enderecoPet = null;
        String ruaEndereco = " ";
        String numeroEndereco = " ";
        String cidadeEndereco = " ";


        // O caminho do arquivo precisa ser ajustado para ser acessível ou relativo
        // Mantendo o caminho que você usou, mas é um ponto de falha comum.
        File file = new File("/home/julio/IdeaProjects/SistemaDeCadastros/src/formulario.txt");

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String linha;

            // Loop para ler todo o arquivo, linha por linha
            while ((linha = br.readLine()) != null) {

                if (linha.isEmpty()) {
                    continue;
                }

                char primeiroCaractere = linha.charAt(0);

                // Lógica de coleta de dados
                if (primeiroCaractere == '1') {
                    System.out.println("----------------------------------------");
                    System.out.println(linha); // 1. Nome Completo:

                    System.out.print("Escreva primeiro o Nome: ");
                    nomePet = scanner.nextLine();

                    System.out.print("Agora escreva o Sobrenome: ");
                    sobrenomePet = scanner.nextLine();

                    System.out.println("-> Resposta Registrada: " + nomePet + " " + sobrenomePet);
                    System.out.println("----------------------------------------");

                }
                else if (primeiroCaractere == '2') {

                    System.out.println("-------------------------------");
                    System.out.println(linha); // Tipo Pet
                    System.out.print("Resposta (Cachorro ou Gato): ");
                    String respostaTipo = scanner.nextLine();

                    // Lógica para converter string em enum TipoPet
                    // (precisa de tratamento de erro)

                    try {
                        tipoPet = TipoPet.valueOf(respostaTipo.toUpperCase());
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Tipo inválido. Usando Cachorro como padrão.");
                        tipoPet = TipoPet.CACHORRO;
                    }
                    System.out.println("Pet: " + tipoPet);
                }
                else if (primeiroCaractere == '3') {
                    System.out.println("-------------------------------");
                    System.out.println(linha); // Sexo Pet
                    System.out.print("Resposta (Macho ou Fêmea): ");
                    String respostaSexo = scanner.nextLine();

                    // Lógica para converter string em enum SexoPet (precisa de tratamento de erro)
                    try {
                        sexoPet = SexoPet.valueOf(respostaSexo.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Sexo inválido. Usando MACHO como padrão.");
                        sexoPet = SexoPet.MACHO;
                    }

                    System.out.println("Sexo: " + sexoPet);

                }
                 else if (primeiroCaractere == '4') {
                 System.out.println("-------------------------------");
                 System.out.println(linha); // Endereço
                 System.out.print("Resposta: ");

//                 ********** Aqui preciso instanciar o endereço e passar 3 atributos
//                  rua, numero e cidade
//
//                  Preciso pegar a resposta do usuário
                    System.out.println("Escreva o nome da sua rua: ");
                    ruaEndereco = scanner.nextLine();

                    System.out.println("Escreva o numero da sua rua: ");
                    numeroEndereco = scanner.nextLine();

                    System.out.println("Escreva o nome da sua cidade: ");
                    cidadeEndereco = scanner.nextLine();



                    enderecoPet = new Endereco(ruaEndereco, numeroEndereco, cidadeEndereco);

                    System.out.println(enderecoPet.toString());
                 }

                else if (primeiroCaractere == '5') {
                    System.out.println("-------------------------------");
                    System.out.println(linha); // Idade
                    System.out.print("Resposta: ");
                    // Tratamento de erro básico para números
                    try {
                        idadePet = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Idade definida como 0.");
                        idadePet = 0;
                    }
                    System.out.println("Idade: " + idadePet);

                }
                else if (primeiroCaractere == '6') {
                    System.out.println("-------------------------------");
                    System.out.println(linha); // Peso
                    System.out.print("Resposta: ");
                    // Tratamento de erro básico para double
                    try {
                        pesoPet = Float.parseFloat(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Peso definido como 0.0.");
                        pesoPet = 0.0F;
                    }
                    System.out.println("Peso: " + pesoPet);

                }
                else if (primeiroCaractere == '7') {
                    System.out.println("-------------------------------");
                    System.out.println(linha); // Raça
                    System.out.print("Resposta: ");
                    racaPet = scanner.nextLine();
                    System.out.println("Raça: " + racaPet);

                }
            }

            // Depois de ler todos os dados, cria e retorna o objeto Pet
            Pet novoPet = new Pet(nomePet, sobrenomePet, enderecoPet, tipoPet, sexoPet, idadePet, pesoPet, racaPet);
            System.out.println("******Dados*******");
            System.out.println(novoPet.toString());

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
            // Em caso de erro fatal, retorna null
            return null;
        } finally {
            // Fecha o Scanner após a conclusão ou falha do try principal
            // É importante fechar o Scanner se ele não for usado em outro lugar no programa.
            scanner.close();
        }
        return null;
    }
}