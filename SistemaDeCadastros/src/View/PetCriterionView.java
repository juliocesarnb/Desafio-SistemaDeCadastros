package View;

import Model.Endereco;
import Model.Pet;
import Model.SexoPet;
import Model.TipoPet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PetCriterionView {
    public static void displayCriterioList() {
        Scanner scanner = new Scanner(System.in);

        // Classe auxiliar interna para armazenar nome
        class PetName {
            String name;
            PetName( String name) {
                this.name = name;
            }
        }

        // ÍNICIO DO MENU
        System.out.println("Você deseja buscar por 1 opção ou 2?");

        // OPÇÃO ENTRE 1 DADO SÓ (EX: NOME) PARA BUSCAR E 2 DADOS (NOME + SEXO)
        int opcaoEscolha = scanner.nextInt();

        // 1. INÍCIO 1 DADO APENAS
            if (opcaoEscolha == 1) {

                // ... (Menu de critérios 1-7) ...
                System.out.println("Digite o dado do pet que deseja fazer a busca: ");

                System.out.println("Nome [1]");

                System.out.println("Sobrenome [2]");

                System.out.println("Sexo [3]");

                System.out.println("Idade [4]");

                System.out.println("Peso [5]");

                System.out.println("Raça [6]");

                System.out.println("Endereço [7]");

                // recebe opção escolhida pelo usuário
                int opcaoDado = scanner.nextInt();
                scanner.nextLine();
                File folderPetsCadastrados = new File("/home/julio/IdeaProjects/SistemaDeCadastros/SistemaDeCadastros/petsCadastrados");

                // Inicio da busca por nome
                // folder = pasta
                // file = arquivo

                    if (opcaoDado == 1) {
                        System.out.println("Escreva o nome do seu pet");
                        String Nome = scanner.nextLine().toUpperCase();

                        // verifica se a pasta é um diretório existente e se for cria uma lista com os arquivos que existem nela.
                        if (folderPetsCadastrados.isDirectory()) {
                            File[] files = folderPetsCadastrados.listFiles();

                            // verifica se os arquivos existem, se existem ele prossegue
                            if (files != null) {
                                // CRIA UM ARRAYLIST PARA O NOME DOS PETS
                                List<PetName> listaPets = new ArrayList<>();

                                // PERCORRE OS ARQUIVOS
                                for (File file : files) {
                                    // VERIFICA SE O ARQUIVO NÃO É NULO
                                    if (file.isFile()) {
                                        // COLOCA O NOME DO ARQUIVO EM UMA VARIÁVEL FILENAME
                                        String fileName = file.getName();

                                        // Lógica de extração de nome do arquivo
                                        int hyphenIndex = fileName.indexOf('-');
                                        int dotIndex = fileName.lastIndexOf('.');
                                        String petName = "";
                                        if (hyphenIndex != -1 && dotIndex != -1 && dotIndex > hyphenIndex) {
                                            petName = fileName.substring(hyphenIndex + 1, dotIndex);
                                        }
                                        listaPets.add(new PetName(petName));
                                    }
                                }

                                System.out.println("=== LISTA DE PETS COM ESSE NOME ===");
                                // PERCORRE A LISTA DE PETS
                                for (int i = 0; i < listaPets.size(); i++) {
                                    // COLOCA A POSIÇÃO NA VARIÁVEL PET
                                    PetName pet = listaPets.get(i);

                                    if (pet.name.equals(Nome)){
                                        System.out.println((i + 1) + ". Pet: " + pet.name);
                                    }

                                }

                            } else {
                                System.out.println("A pasta está vazia ou não foi possível ler.");
                            }
                        } else {
                            System.out.println("O caminho fornecido não é um diretório válido.");
                        }
                } // FECHA: if (opcaoDado == 1)

                // CORREÇÃO 2: FECHA o if (opcaoEscolha == 1) aqui.
                // O restante do código deve estar no mesmo nível lógico.

            } else if (opcaoEscolha == 2) {
                System.out.println("Escolha a primeira opção de busca:");
                System.out.println("Nome [1]");
                // ... resto do menu para a opção 2
            } else {
                System.out.println("Erro");
            } // FECHA: if-else if-else block

    } // FECHA: displayCriterioList()
} // FECHA: PetCriterionView