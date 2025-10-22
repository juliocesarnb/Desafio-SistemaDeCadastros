import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MenuInicial {
    public static void main(String[] args) {
        System.out.println("-----* MENU INICIAL DE CADASTRO DE PETS *-------");
        System.out.println("1. Cadastrar novo pet");
        System.out.println("2. Alterar os dados do pet cadastrado");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6. Sair");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a opção desejada: ");
        int opcaoDoUsuario = scanner.nextInt();

        if (opcaoDoUsuario == 1){
            System.out.println("Iremos cadastrar um novo pet");
            // Aqui iremos pegar o arquivo: formulario.txt
            // e printa-lo na tela (Da primeira pergunta até a sétima, separadamente)

            File file = new File("formulario.txt");
            try(FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)){
                String linha;
                if((linha = br.readLine()) != null){
                    System.out.println(linha);
                    String nomeDoPet = scanner.next();
                }

            }catch (IOException e){
                e.printStackTrace();
            }


        }
        else if (opcaoDoUsuario == 2){
            System.out.println("Iremos alterar os dados do pet cadastrado");
        }
        else if (opcaoDoUsuario == 3){
            System.out.println("Iremos deletar os dados do pet");
        }
        else if (opcaoDoUsuario == 4){
            System.out.println("Iremos listar todos os pets cadastrados");
        }
        else if (opcaoDoUsuario == 5){
            System.out.println("Iremos listar os dados do pet");
        }
        else if (opcaoDoUsuario == 6){
            System.out.println("Sair do menu");
        }

        // O usuário não poderá usar 0 ou números negativos.
        //Caso o usuário digite um número inválido, o menu deve ser exibido novamente.
        //O usuário só poderá digitar números, não podendo digitar letras ou caracteres especiais.
        while (opcaoDoUsuario <= 0){
            System.out.println("Opção inválida, digite apenas os números que estão listados.");
            System.out.println("--------------------------------------");
            System.out.println("-----* MENU INICIAL DE CADASTRO DE PETS *-------");
            System.out.println("1. Cadastrar novo pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6. Sair");
            System.out.println("--------------------------------------");
            System.out.println("Digite a novamente a opção desejada: ");
            int opcaoDoUsuario1 = scanner.nextInt();

        }

    }
}
