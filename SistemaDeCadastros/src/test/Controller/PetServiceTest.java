package Controller;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static org.junit.jupiter.api.Assertions.*;

public class PetServiceTest {

    @Test
    public void testeFormatacaoDataNomeArquivo() {
        // Original:
        LocalDateTime dataTeste = LocalDateTime.now();
        System.out.println(dataTeste);

        // Act - Tente formatar de várias formas
        String resultado1 = dataTeste.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println("Formato 1: " + resultado1); // 20231101

        String resultado2 = dataTeste.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("Formato 2: " + resultado2); // 2023-11-01T12:34:00

        // Teste 3: Seu formato exato
        String resultado3 = dataTeste.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm"));
        System.out.println("Formato 3: " + resultado3); // 20251030T1408

        // Teste 4: Seu formato exato que irá ser usado
        String resultado4 = dataTeste.format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm"));
        System.out.println("Formato 4 (Formatado): " + resultado4); // 20251030T1408

        // Assert - Verifique se está correto
        assertEquals(resultado4, resultado3,
                "A formatação da data deve ser yyyyMMddTHHmm");
    }
    @Test
    public void testeConcatenacaoNomeMaiusculo() {
        // Arrange

        String nome = "Florzinha";
        String sobrenome = "da Silva";

        // Concatenação correta de TEXTO para o título dos arquivos petsCadastrados
        String nomeCompleto = (nome + sobrenome).toUpperCase().trim().replaceAll("\\s", "");
        System.out.println("Nome completo maiúsculo: " + nomeCompleto+ ".TXT");

        // Assert
        assertEquals("FLORZINHADASILVA", nomeCompleto,
                "Nome deve ser concatenado e em maiúsculo sem espaços");
    }

}
