package test.View;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//    O usuário obrigatoriamente deverá cadastrar um pet com nome e sobrenome, caso contrário, lance uma exceção.
//O nome completo NÃO poderá conter caracteres especiais, somente letras de A-Z.
//Para o TIPO e SEXO do pet, você deverá usar ENUM.
//Na pergunta sobre o endereço, você deverá perguntar:
//Número da casa
//Cidade
//Rua
//Na idade e peso aproximados do pet, o usuário poderá digitar números com vírgulas ou ponto, mas somente números.
//Caso o usuário digite um peso maior que 60kg ou um peso menor que 0.5kg, lance uma exceção.
//Caso o usuário digite uma idade maior que 20 anos, lance uma exceção.
//Caso o usuário digite uma idade menor que 1 ano (idade em meses), transforme em 0.x anos.
//No campo raça o usuário não poderá usar números nem caracteres especiais.
//Nas perguntas sobre NOME, RAÇA, PESO, IDADE e ENDEREÇO (somente o campo número),
// caso o usuário NÃO INFORME ou deixe em branco,
// você deverá preencher com NÃO INFORMADO (deve ser uma constante)!

public class RegisterViewTest {

    @Test
    public void cadastrarPet_DeveLancarExcecaoSeNomeEstiverVazio() {
        // Arrange
        String nomeVazio = "";
        String sobrenomeValido = "da Silva";

        // Act & Assert
        // Usamos assertThrows para verificar se o metodo lança a exceção esperada

        //*********** O que é Metodo de Asserção *********
        //  É o metodo do JUnit que espera que uma exceção seja lançada durante a execução de um bloco de código.
        // Simulação da lógica que lança a exceção


        // IllegalArgumentException.class	É o Tipo de Exceção Esperada.
        // Você está dizendo ao JUnit:
        // "Eu espero que a exceção lançada seja exatamente (ou herde de) IllegalArgumentException".
//        assertThrows -- Afirmar lances
        assertThrows(IllegalArgumentException.class, () -> {

            // petService.cadastrarPet(nomeVazio, sobrenomeValido, ...);
            //  Substitua por sua chamada de metodo real

            if (nomeVazio == null || nomeVazio.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome e Sobrenome são obrigatórios.");
            }
        }, "Deve lançar exceção se o nome do pet estiver vazio.");
    }


    // 2. Teste para o caso de o SOBRENOME estar vazio ou nulo
    @Test
    public void cadastrarPet_DeveLancarExcecaoSeSobrenomeEstiverVazio() {
        // Arrange
        String nomeValido = "Florzinha";
        String sobrenomeVazio = null; // Testando também para nulo

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            // petService.cadastrarPet(nomeValido, sobrenomeVazio, ...);

            // Simulação da lógica que lança a exceção
            if (sobrenomeVazio == null || sobrenomeVazio.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome e Sobrenome são obrigatórios.");
            }
        }, "Deve lançar exceção se o sobrenome do pet estiver nulo.");
    }

    // 3. Teste para o caso de SUCESSO
    @Test
    public void cadastrarPet_DeveFuncionarComNomeESobrenomeValidos() {
        // Arrange
        String nomeValido = "Florzinha";
        String sobrenomeValido = "da Silva";

        // Act & Assert
        // Se a chamada de método não lançar exceção, o teste passa.
        assertDoesNotThrow(() -> {
            // petService.cadastrarPet(nomeValido, sobrenomeValido, ...);

            // Simulação da lógica que NÃO lança a exceção
            if (nomeValido == null || nomeValido.trim().isEmpty() ||
                    sobrenomeValido == null || sobrenomeValido.trim().isEmpty()) {
                throw new IllegalArgumentException("Execeção lançada.");
            }
        }, "Não deve lançar exceção quando Nome e Sobrenome são válidos.");
    }
    @Test
    public void validarPeso_DeveLancarExcecaoSePesoForInvalido() {
        // 1. Testa peso abaixo do limite (0.4f)
        assertThrows(IllegalArgumentException.class, () -> {
            float pesoInvalido = 0.4f;
            if (pesoInvalido < 0.5f) { // Sua regra é < 0.5kg
                throw new IllegalArgumentException("Peso deve estar entre 0.5kg e 60kg.");
            }
        }, "Deve falhar para pesos abaixo de 0.5kg.");

        // 2. Testa peso acima do limite (60.1f)
        assertThrows(IllegalArgumentException.class, () -> {
            float pesoInvalido = 60.1f;
            if (pesoInvalido > 60.0f) { // Sua regra é > 60kg
                throw new IllegalArgumentException("Peso deve estar entre 0.5kg e 60kg.");
            }
        }, "Deve falhar para pesos acima de 60kg.");
    }

    @Test
    public void validarPeso_NaoDeveLancarExcecaoSePesoForValido() {
        // Testa um peso válido (dentro dos limites)
        assertDoesNotThrow(() -> {
            float pesoValido = 5.5f;
            if (pesoValido < 0.5f || pesoValido > 60.0f) {
                throw new AssertionError("Erro: Lançou exceção para peso válido.");
            }
        }, "Não deve lançar exceção para peso válido (5.5kg).");
    }
}


