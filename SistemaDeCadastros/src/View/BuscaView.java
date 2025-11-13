package View;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BuscaView {
    // Classe auxiliar interna para armazenar nome + hora
    static class PetInfo {
        String name;
        String registrationTime;

        PetInfo(String name, String registrationTime) {
            this.name = name;
            this.registrationTime = registrationTime;
        }
    }

    public static void displayList() {

        File folderPetsCadastrados = new File("/home/julio/IdeaProjects/SistemaDeCadastros/SistemaDeCadastros/petsCadastrados");

        if (folderPetsCadastrados.isDirectory()) {
            File[] files = folderPetsCadastrados.listFiles();

            if (files != null) {

                // Cria uma lista de objetos PetInfo, que vai armazenar todos os pets encontrados.

                //Cada PetInfo guarda:
                //O nome do pet (name)
                //A hora do cadastro (registrationTime)
                List<PetInfo> listaPets = new ArrayList<>();

                //Loop que percorre todos os arquivos da pasta
                for (File file : files) {
                    // Verifica se o item é realmente um arquivo (e não uma subpasta).
                    // Depois pega o nome do arquivo (por exemplo: "20251030T1607-BATATAJUNIOR.TXT").
                    if (file.isFile()) {
                        String fileName = file.getName();

                        // Extrair nome do pet (parte entre '-' e '.')
                        int hyphenIndex = fileName.indexOf('-');
                        int dotIndex = fileName.lastIndexOf('.');
                        String petName = "";

                        if (hyphenIndex != -1 && dotIndex != -1 && dotIndex > hyphenIndex) {
                            petName = fileName.substring(hyphenIndex + 1, dotIndex);
                        }

                        // Extrair hora de cadastro (parte entre 'T' e '-')
                        int timeIndex = fileName.indexOf('T');
                        String registrationTime = "";

                        if (timeIndex != -1 && hyphenIndex != -1 && hyphenIndex > timeIndex) {
                            registrationTime = fileName.substring(timeIndex + 1, hyphenIndex);
                        }

                        // Adiciona pet à lista
                        // Cria um novo objeto PetInfo com as informações do pet e adiciona à lista.
                        listaPets.add(new PetInfo(petName, registrationTime));
                    }
                }

                Collections.sort(listaPets, Comparator.comparingInt(p -> Integer.parseInt(p.registrationTime)));

//                      Forma manual (sem Comparator)
//                for (int i = 0; i < listaPets.size() - 1; i++) {
//                    for (int j = i + 1; j < listaPets.size(); j++) {
//                        int hora1 = Integer.parseInt(listaPets.get(i).registrationTime);
//                        int hora2 = Integer.parseInt(listaPets.get(j).registrationTime);
//
//                        if (hora1 > hora2) {
//                            PetInfo temp = listaPets.get(i);
//                            listaPets.set(i, listaPets.get(j));
//                            listaPets.set(j, temp);
//                        }
//                    }
//                }

                // Exibir pets ordenados
                System.out.println("=== LISTA DE PETS ORDENADA POR HORA DE CADASTRO ===");
                for (int i = 0; i < listaPets.size(); i++) {
                    PetInfo pet = listaPets.get(i);
                    System.out.println((i + 1) + ". Pet: " + pet.name + " | Hora: " + pet.registrationTime);
                }

            } else {
                System.out.println("A pasta está vazia ou não foi possível ler.");
            }
        } else {
            System.out.println("O caminho fornecido não é um diretório válido.");
        }
    }
}
