package Model;
//Número da casa
//Cidade
//Rua
;

    public class Endereco {
        private String rua;
        private String numero;
        private String cidade;

        // Construtor
        public Endereco(String rua, String numero, String cidade) {
            this.rua = rua;
            this.numero = numero != null && !numero.isBlank() ? numero : Pet.NAO_INFORMADO;
            this.cidade = cidade;
        }

        // Método toString() para formato: "Rua X, 123, Cidade Y"

        @Override
        public String toString() {
            return rua + ", " + numero + ", " + cidade;
        }
    }



