package Service;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import Model.Pet;
public class PetService {

    public static boolean salvar(Pet novoPet) {
        // Criar pasta "petsCadastrados" se não existir
        File pastaPets = new File("petsCadastrados");
        if (!pastaPets.exists()) {
            boolean created = pastaPets.mkdirs();
            System.out.println("DEBUG: Pasta criada? " + created);
        } else {
            System.out.println("DEBUG: Pasta já existe");
        }

        // Formatar a data para o padrão yyyyMMddTHHmm
        String dataFormatada = novoPet.getDataCadastro()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm"));

        // Concatenar nome e sobrenome em maiúsculo e sem espaços
        String nomeCompleto = (novoPet.getNome() + novoPet.getSobrenome())
                .toUpperCase()
                .replaceAll("\\s+", "");

        // Criar objeto File para o arquivo com nome correto dentro da pasta
        String nomeArquivo = dataFormatada + "-" + nomeCompleto + ".TXT";
        File arquivo = new File(pastaPets, nomeArquivo);
        System.out.println("DEBUG: Arquivo de destino: " + arquivo.getAbsolutePath());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            // Escreve uma linha por informação, conforme exemplo
            bw.write("1 - " + novoPet.getNome() + " " + novoPet.getSobrenome());
            bw.newLine();

            bw.write("2 - " + novoPet.getTipo());
            bw.newLine();

            bw.write("3 - " + novoPet.getSexo());
            bw.newLine();

            bw.write("4 - " + novoPet.getEndereco());
            bw.newLine();

            bw.write("5 - " + novoPet.getIdade());
            bw.newLine();

            bw.write("6 - " + novoPet.getPeso());
            bw.newLine();

            bw.write("7 - " + novoPet.getRaca());
            bw.newLine();

            bw.flush();

            System.out.println("DEBUG: Dados gravados com sucesso");
            return true;
        } catch (IOException e) {
            System.out.println("DEBUG: Erro ao gravar arquivo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
