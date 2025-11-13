package View;

public class MensagemView {

    public static void sucesso(String mensagem) {
        System.out.println("\n✓ " + mensagem);
    }

    public static void erro(String mensagem) {
        System.out.println("\n✗ Erro: " + mensagem);
    }

    public static void info(String mensagem) {
        System.out.println("\nℹ " + mensagem);
    }

    public static void linha() {
        System.out.println("─────────────────────────────────────────");
    }
}