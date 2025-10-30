package Service;

import Model.Pet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class PetService {
    // Preciso salvar um objeto em um arquivo .txt que tenha o seguinte formato
    // ano, mês, dia,T, hora, minuto - NOME+SOBRENOME em maiúsculo.
    // Ex: 20231101T1234-FLORZINHADASILVA.TXT. -> COMO?

    // Exemplo do conteúdo do arquivo:
    //1 - Florzinha da Silva
    //2 - Gato
    //3 - Femea
    //4 - Rua 2, 456, Seilandia
    //5 - 6 anos
    //6 - 5kg
    //7 - Siames

    // O arquivo deverá ser ---- salvo na pasta petsCadastrados na raiz do projeto---
    // O conteúdo do arquivo deverá conter TODAS AS RESPOSTAS POR LINHA, ou seja, cada resposta deverá estar em uma linha diferente.
    // O campo endereço deverá ser salvo todo na mesma linha.
    // O arquivo somente conterá RESPOSTAS, PERGUNTAS NÃO!



    public static boolean salvar(Pet novoPet) {
        // pasta criada:
        File file_petsCadastrados = new File("petsCadastrados");

        // BOOLEAN validador de true or false da pasta
        boolean isPetCadastrados = file_petsCadastrados.mkdir();

        // INICIALIZANDO dados que iram estar no TITULO do arquivo
        LocalDateTime dataArquivo = novoPet.getDataCadastro();
        String nomeArquivo = novoPet.getNome().toUpperCase();
        String sobrenomeArquivo = novoPet.getSobrenome().toUpperCase();

        // arquivo criado:
        File fileArquivo_petsCadastradados = new File(file_petsCadastrados,  dataArquivo + nomeArquivo + sobrenomeArquivo );

        try (FileWriter fw = new FileWriter(file_petsCadastrados, true);
             BufferedWriter br = new BufferedWriter(fw)){
            br.write(novoPet.toString());
            br.flush();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        // boolean validador de true or false do arquivo
        try {
            boolean isFileCreated = fileArquivo_petsCadastradados.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return isPetCadastrados;
    }
}
