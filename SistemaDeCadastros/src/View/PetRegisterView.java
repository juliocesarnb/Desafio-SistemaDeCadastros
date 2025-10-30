package View;

import Model.Endereco;
import Model.Pet;
import Model.SexoPet;
import Model.TipoPet;

import java.io.*;
import java.util.Scanner;


public class PetRegisterView {

         // Gerencia a interface de cadastro de novos pets.
        //  O metodo agora RETORNA um objeto Pet

        //  Métodos:
        //  exibirMenu(); Renderiza os campos do formulário de entrada

        //  ExibirFormulario(): Exibe o formulário de cadastro e
        //  coleta todos os campos
        //  (nome,sobrenome, tipo, sexo, endereço (Rua, Número, Cidade), idade, peso, raça )
        //  do usuário via Scanner e retorna um objeto Pet preenchido


//        EXIBIR FORMULÁRIO LINHA POR LINHA

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


            File file = new File("/home/julio/IdeaProjects/SistemaDeCadastros/SistemaDeCadastros/src/formulario.txt");

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


// ****** Ver se consigo instanciar endereço no CadastroPet
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

                // ✅ CORREÇÃO PRINCIPAL: Retorna o objeto criado
                Pet novoPet = new Pet(nomePet, sobrenomePet, enderecoPet, tipoPet, sexoPet, idadePet, pesoPet, racaPet);

                System.out.println("\n******Dados Coletados*******");
                System.out.println(novoPet.toString());

                return novoPet; // ✅ RETORNA O PET CRIADO

            } catch (FileNotFoundException e) {
                System.err.println("❌ Erro: Arquivo 'formulario.txt' não encontrado em src/");
                System.err.println("Verifique se o arquivo existe no diretório: " + file.getAbsolutePath());
                return null;

            } catch (IOException e) {
                System.err.println("❌ Erro ao ler o arquivo: " + e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
}

