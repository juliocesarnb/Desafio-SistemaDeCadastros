package Model;

import java.time.LocalDateTime;

public class Pet {

    private String nome;
    private String sobrenome;
    private String nomeCompleto;
    private TipoPet tipo;
    private SexoPet sexo;
    private double idade;
    private double peso;
    private String raca;
    private Endereco endereco;
    private LocalDateTime dataCadastro;

    // Constante para valores não informados
    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    //Construtor
    public Pet() {
        this.endereco = null;
        this.nome = null;
        this.sobrenome = null;
        this.nomeCompleto = null;
        this.tipo = tipo;
        this.sexo = sexo;
        this.idade = idade;
        this.peso = peso;
        this.raca = null;
        this.dataCadastro = LocalDateTime.now();
    }

    // Getters and Setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public TipoPet getTipo() {
        return tipo;
    }

    public void setTipo(TipoPet tipo) {
        this.tipo = tipo;
    }

    public SexoPet getSexo() {
        return sexo;
    }

    public void setSexo(SexoPet sexo) {
        this.sexo = sexo;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataCadastro() { return dataCadastro; }

    // ******** FIM DOS GETTERS AND SETTERS

}
