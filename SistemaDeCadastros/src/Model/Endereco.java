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
            this.rua = rua != null && !rua.isBlank() ? rua : Pet.NAO_INFORMADO;
            this.numero = numero != null && !numero.isBlank() ? numero : Pet.NAO_INFORMADO;
            this.cidade = cidade != null && !cidade.isBlank() ? cidade : Pet.NAO_INFORMADO;
        }
        // Getters, setters

        public String getRua() {
            return rua;
        }

        public void setRua(String rua) {
            this.rua = rua;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }
        // Método toString() para formato: "Rua X, 123, Cidade Y"

        @Override
        public String toString() {
            return rua + ", " + numero + ", " + cidade;
        }
    }



