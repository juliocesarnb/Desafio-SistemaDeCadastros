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
            double idadePet = 0.0F;
            float pesoPet= 0.0F;
            String racaPet = "";
            Endereco enderecoPet = null;
            String rua = " ";
            String numero = " ";
            String cidade = " ";
            String regexCaracterEspecial = "^[a-zA-Z]+$";
            String regexNumeros = "^\\d+$";

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

                        if (nomePet == null || nomePet.trim().isEmpty()) {
                            throw new IllegalArgumentException("Nome é obrigatório.");
                        }

                        System.out.print("Agora escreva o Sobrenome: ");
                        sobrenomePet = scanner.nextLine();

                        if (sobrenomePet == null || sobrenomePet.trim().isEmpty()) {
                            throw new IllegalArgumentException("Sobrenome é obrigatório.");
                        }

                        String nomeCompleto = nomePet + sobrenomePet;

                        if(nomeCompleto.matches(regexCaracterEspecial)){
                            System.out.println("-> Resposta Registrada: " + nomePet + " " + sobrenomePet);
                            System.out.println("----------------------------------------");
                        }
                        else {
                            throw new IllegalArgumentException("Nome completo não pode conter caractéres especiais.");
                        }


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
                        rua = scanner.nextLine();

                        System.out.println("Escreva o numero da sua rua: ");
                        numero = scanner.nextLine();

                        System.out.println("Escreva o nome da sua cidade: ");
                        cidade = scanner.nextLine();


                        enderecoPet = new Endereco(rua, numero, cidade);

                        System.out.println(enderecoPet.toString());
                    }

                    else if (primeiroCaractere == '5') {
                        System.out.println("-------------------------------");
                        System.out.println(linha); // 5. Idade
                        System.out.print("Resposta (em anos. Use vírgula ou ponto): ");

                        // Variável para armazenar a entrada do usuário
                        String resposta = scanner.nextLine().replace(',', '.');
                        float idadeLida = 0.0F;

                        try {
                            idadeLida = Float.parseFloat(resposta);
                        } catch (NumberFormatException e) {
                            // Se falhar a conversão para Float (usuário digitou letras), usa o padrão 0.
                            System.out.println("Entrada inválida. Idade definida como 0 (Não Informado).");
                            idadeLida = 0.0F;
                        }

                        if (idadeLida > 20.0f) {
                            throw new IllegalArgumentException("Idade máxima permitida é 20 anos.");
                        }

                        // --- Início da Lógica de Conversão Solicitada ---

                        // 1. Obter a parte inteira (Anos)
                        int anos = (int) idadeLida;

                        // 2. Obter a parte decimal (Meses, como um dígito)
                        //    a) Subtrair a parte inteira para isolar o decimal (Ex: 1.2 - 1 = 0.2)
                        //    b) Multiplicar por 10 e arredondar para o inteiro mais próximo (Ex: 0.2 * 10 = 2)
                        int meses = Math.round((idadeLida - anos) * 10);

                        // Ajuste para casos como 0.99 que podem arredondar para 10, mas devem ser 9
                        if (meses == 10) {
                            meses = 9;
                        }

                        // 3. Formatar a saída
                        String idadeFormatada;
                        if (anos > 0 && meses > 0) {
                            // Ex: 1 ano e 2 meses
                            idadeFormatada = String.format("%d ano%s e %d mese%s",
                                    anos, (anos > 1 ? "s" : ""),
                                    meses, (meses > 1 ? "s" : ""));
                        } else if (anos > 0) {
                            // Ex: 1 ano
                            idadeFormatada = String.format("%d ano%s", anos, (anos > 1 ? "s" : ""));
                        } else if (meses > 0) {
                            // Ex: 4 meses (para entradas como 0.4)
                            idadeFormatada = String.format("%d mese%s", meses, (meses > 1 ? "s" : ""));
                        } else {
                            // Ex: 0 (para entrada 0.0)
                            idadeFormatada = "0 (Não Informado)";
                        }

                        // Você pode usar 'idadeLida' como a idade do pet em anos no formato 1.2, se precisar desse valor.
                         idadePet = idadeLida;

                        // Imprimindo a saída solicitada
                        System.out.printf("Idade convertida de %.1f anos, para %s.\n", idadeLida, idadeFormatada);

                        // Linha final do seu código
                        System.out.println("Idade: " + idadeFormatada);
                    }

                    else if (primeiroCaractere == '6') {
                        System.out.println("-------------------------------");
                        System.out.println(linha); // Peso
                        System.out.print("Resposta: ");
                        // Tratamento de erro básico para double
                        try {
                            pesoPet = Float.parseFloat(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            if (pesoPet < 0.5f || pesoPet > 60.0f) {
                                throw new AssertionError("Erro: Peso inválido");
                            }
                        }


                        System.out.println("Peso: " + pesoPet);

                    }
                    else if (primeiroCaractere == '7') {
                        System.out.println("-------------------------------");
                        System.out.println(linha); // Raça
                        System.out.print("Resposta: ");
                        racaPet = scanner.nextLine();
                        System.out.println("Raça: " + racaPet);
                        if(racaPet.matches(regexCaracterEspecial)){
                            System.out.println("-> Resposta Registrada: " + nomePet + " " + sobrenomePet);
                            System.out.println("----------------------------------------");
                        }
                        else {
                            throw new IllegalArgumentException("raça não pode conter caractéres especiais nem números.");
                        }

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

