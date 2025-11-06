package Model;

import java.time.LocalDateTime;

public class Pet {

    private String nome;
    private String sobrenome;
    private TipoPet tipo;
    private SexoPet sexo;
    private double idade;
    private float peso;
    private String raca;
    private Endereco endereco;
    private LocalDateTime dataCadastro;

    // Constante para valores não informados
    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    //Construtor
    public Pet(String nome, String sobrenome, Endereco endereco, TipoPet tipo, SexoPet sexo, double idade, float peso, String raca) {
        this.endereco = endereco;
        this.nome = nome != null && !nome.isBlank() ? nome : Pet.NAO_INFORMADO;
        this.sobrenome = sobrenome != null && !sobrenome.isBlank() ? sobrenome : Pet.NAO_INFORMADO;
        this.tipo = tipo;
        this.sexo = sexo;
        this.idade = idade;
        this.peso = peso;
        this.raca =  raca != null && !raca.isBlank() ? raca : Pet.NAO_INFORMADO;
        // 1. Inicializa o campo dataCadastro
        this.dataCadastro = LocalDateTime.now();
    }

    // Getters and Setters
    public Endereco getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public TipoPet getTipo() {
        return tipo;
    }

    public SexoPet getSexo() {
        return sexo;
    }

    // Na idade e peso aproximados do pet,
    // o usuário poderá digitar números com vírgulas ou ponto, mas somente números.
    public double getIdade() {
        return idade;
    }

    public float getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
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
