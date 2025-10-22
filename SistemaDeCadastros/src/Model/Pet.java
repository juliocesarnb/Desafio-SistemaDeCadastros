package Model;

import java.time.LocalDateTime;

public class Pet {


    private String nome;
    private String sobrenome;
    private TipoPet tipo;
    private SexoPet sexo;
    private int idade;
    private float peso;
    private String raca;
    private Endereco endereco;
    private LocalDateTime dataCadastro;

    // Constante para valores não informados
    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    // validar o nome e sobrenome



    //Construtor
    public Pet(String nome, String sobrenome, Endereco endereco, TipoPet tipo, SexoPet sexo, int idade, float peso, String raca) {
        this.endereco = endereco;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
        // 1. Inicializa o campo dataCadastro
        this.dataCadastro = LocalDateTime.now();
    }

    // Getters and Setters
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public LocalDateTime getDataCadastro() { return dataCadastro; }

    @Override
    public String toString() {
        return "Pet{" +
                "endereco=" + endereco +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", tipo=" + tipo +
                ", sexo=" + sexo +
                ", idade=" + idade +"anos"+
                ", peso=" + peso +"kg"+
                ", raca='" + raca + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
