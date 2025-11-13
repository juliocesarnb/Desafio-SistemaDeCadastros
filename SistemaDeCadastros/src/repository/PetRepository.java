// PetRepository.java
package repository;

import Model.Pet;
import Util.Constantes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class PetRepository {

    public PetRepository() {
        criarPastaPets();
    }

    private void criarPastaPets() {
        File pasta = new File(Constantes.PASTA_PETS);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }
    }

    public void salvar(Pet pet) {
        String nomeArquivo = gerarNomeArquivo(pet);
        String caminhoCompleto = Constantes.PASTA_PETS + File.separator + nomeArquivo;

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(caminhoCompleto));

            // Linha 1 - Nome completo
            bw.write("1 - " + pet.getNomeCompleto());
            bw.newLine();

            // Linha 2 - Tipo
            bw.write("2 - " + pet.getTipo());
            bw.newLine();

            // Linha 3 - Sexo
            bw.write("3 - " + pet.getSexo());
            bw.newLine();

            // Linha 4 - Endereço
            bw.write("4 - " + pet.getEndereco().toString());
            bw.newLine();

            // Linha 5 - Idade
            String idadeStr = pet.getIdade() == 0 ?
                    Constantes.NAO_INFORMADO :
                    pet.getIdade() + " anos";
            bw.write("5 - " + idadeStr);
            bw.newLine();

            // Linha 6 - Peso
            String pesoStr = pet.getPeso() == 0 ?
                    Constantes.NAO_INFORMADO :
                    pet.getPeso() + "kg";
            bw.write("6 - " + pesoStr);
            bw.newLine();

            // Linha 7 - Raça
            bw.write("7 - " + pet.getRaca());

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar o pet: " + e.getMessage());
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar arquivo");
                }
            }
        }
    }

    private String gerarNomeArquivo(Pet pet) {
        // Formato: 20231101T1234-FLORZINHADASILVA.TXT
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dataHora = dtf.format(pet.getDataCadastro());

        String nome = pet.getNome() != null ? pet.getNome() : "";
        String sobrenome = pet.getSobrenome() != null ? pet.getSobrenome() : "";

        String nomeCompleto = (nome + " " + sobrenome)
                .toUpperCase()
                .trim() // Remove espaços extras da ponta (se um dos campos for vazio)
                .replace(" ", ""); // Remove o espaço entre o nome e o sobrenome
        return dataHora + "-" + nomeCompleto + ".TXT";

    }
}