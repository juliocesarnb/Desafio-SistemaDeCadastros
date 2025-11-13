package View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FormularioView {
    File file = new File("/home/julio/IdeaProjects/SistemaDeCadastros/SistemaDeCadastros/src/formulario.txt");
    // Campo no nível da classe
    private String PerguntaNomeCompleto;
    private String PerguntaTipo;
    private String PerguntaSexo;
    private String PerguntaEndereco;
    private String PerguntaIdade;
    private String PerguntaPeso;
    private String PerguntaRaca;

    //getter publico para acesso externo
    // ******** NomeCompleto ********
    public String getPerguntaNomeCompleto() {
        return PerguntaNomeCompleto;
    }
    // ******** TIPO ********
    public String getPerguntaTipo() {
        return PerguntaTipo;
    }
    // ******** SEXO ********
    public String getPerguntaSexo() {
        return PerguntaSexo;
    }
    // ******** ENDEREÇO ********
  public String getPerguntaEndereco() {
        return PerguntaEndereco;
    }
    // ******** IDADE ********
  public String getPerguntaIdade() {
        return PerguntaIdade;
    }
    // ******** PESO ********
    public String getPerguntaPeso() {
        return PerguntaPeso;
    }
    // ******** RAÇA ********
    public String getPerguntaRaca() {
        return PerguntaRaca;
    }

    public void leitorDeFormulario(){
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String linha;

            // Loop para ler todo o arquivo, linha por linha
            while ((linha = br.readLine()) != null) {

                if (linha.isEmpty()) {
                    continue;
                }

                char primeiroCaractere = linha.charAt(0);

                // Exemplo de lógica de coleta de dados
                if (primeiroCaractere == '1') {
                    this.PerguntaNomeCompleto = linha;
                }
                else if (primeiroCaractere == '2') {
                     this.PerguntaTipo = linha;
                }
                else if (primeiroCaractere == '3') {
                    this.PerguntaSexo = linha;
                }
                else if (primeiroCaractere == '4') {
                    this.PerguntaEndereco = linha;
                }
                else if (primeiroCaractere == '5') {
                    this.PerguntaIdade = linha;
                }
                else if (primeiroCaractere == '6') {
                    this.PerguntaPeso = linha;
                }
                else if (primeiroCaractere == '7') {
                    this.PerguntaRaca = linha;
                    System.out.println("─────────────────────────────────────────");
                }
            }

        } catch (IOException e) {
            // Trata erros de leitura/arquivo não encontrado
            System.err.println("Erro ao ler o arquivo do formulário: " + e.getMessage());
            e.printStackTrace();
        }
    }
}