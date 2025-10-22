package Model;

public enum SexoPet {
    MACHO,
    FEMEA,
    NAO_INFORMADO;

    public static SexoPet fromString(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("A string de entrada não pode ser nula.");
        }

        // Lógica de conversão case-insensitive
        for (SexoPet sexo : SexoPet.values()) {
            if (sexo.name().equalsIgnoreCase(texto.trim())) {
                return sexo;
            }
        }

        // Se a string não corresponder a nenhum valor
        throw new IllegalArgumentException("Nenhum SexoPet encontrado para a string: " + texto);
    }
}