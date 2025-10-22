package Model;

public enum TipoPet {
    CACHORRO,
    GATO;

    /**
     * Método para converter String para Enum de forma case-insensitive.
     *
     * @param texto A string a ser convertida (ex: "gato", "Cachorro", "passaro").
     * @return O valor do enum TipoPet correspondente.
     * @throws IllegalArgumentException Se a string não corresponder a nenhum valor do enum.
     */
    public static TipoPet fromString(String texto) {
        // Verifica se a string de entrada não é nula
        if (texto == null) {
            throw new IllegalArgumentException("A string de entrada não pode ser nula.");
        }

        // Itera sobre todos os valores do enum TipoPet
        for (TipoPet tipo : TipoPet.values()) {
            // Compara o nome do enum (ex: "CACHORRO") com a string de entrada (ex: "cachorro")
            // de forma case-insensitive
            if (tipo.name().equalsIgnoreCase(texto.trim())) {
                return tipo;
            }
        }

        // Se o loop terminar sem encontrar uma correspondência
        throw new IllegalArgumentException("Nenhum TipoPet encontrado para a string: " + texto);
    }
}