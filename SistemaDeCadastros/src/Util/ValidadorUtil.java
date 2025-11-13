package Util;

import Exception.DadosInvalidosException;

public class ValidadorUtil {

    // Valida se o nome tem apenas letras e espaços
    public static boolean validarNomeApenasLetras(String nome) {
        // Percorre cada caractere
        for (int i = 0; i < nome.length(); i++) {
            char c = nome.charAt(i);

            // Se não for letra nem espaço, retorna false
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    // Valida se tem nome E sobrenome (pelo menos 2 palavras)
    public static boolean temNomeESobrenome(String nomeCompleto) {
        // Remove espaços das pontas e divide por espaço
        String[] partes = nomeCompleto.trim().split(" ");

        // Precisa ter pelo menos 2 partes
        if (partes.length < 2) {
            return false;
        }

        // Verifica se o sobrenome não está vazio
        return !partes[1].trim().isEmpty();
    }

    public static void validarPeso(double peso) throws DadosInvalidosException {
        if (peso < Constantes.PESO_MINIMO || peso > Constantes.PESO_MAXIMO) {
            throw new DadosInvalidosException(
                    "Peso deve estar entre " + Constantes.PESO_MINIMO +
                            "kg e " + Constantes.PESO_MAXIMO + "kg"
            );
        }
    }

    public static void validarIdade(double idade) throws DadosInvalidosException {
        if (idade > Constantes.IDADE_MAXIMA) {
            throw new DadosInvalidosException(
                    "Idade máxima permitida é " + Constantes.IDADE_MAXIMA + " anos"
            );
        }
    }

    public static boolean validarRacaApenasLetras(String raca) {
        for (int i = 0; i < raca.length(); i++) {
            char c = raca.charAt(i);
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}