package Views;

import Ferramentas.Ferramentas;

import java.net.UnknownHostException;

public class MenuInicial {

    public static void menuInicial() throws UnknownHostException {

        boolean continuar = true;

        while(continuar) {
            System.out.println("------------");
            System.out.println("MENU INICIAL");
            System.out.println("------------");

            System.out.println(); // pula a linha

            System.out.println("[1] - (Adicionar/Trocar) LOCAL DO ARQUIVO");
            System.out.println("[2] - OBTER AS INFORMAÇÕES");
            System.out.println("[3] - SAIR DO SISTEMA");

            System.out.println(); // PULA LINHA

            System.out.print("DIGITE SUA OPÇÃO: ");
            int op = Ferramentas.lerOp();

            Ferramentas.limparTerminal();

            switch (op) {

                case 1 -> {
                    MenuCaminho.menuCaminho();
                }

                case 2 -> {
                    MenuLeitor.menuLeitor();
                }

                case 3 -> {
                    MenuSair.menuSair();
                    continuar = false;
                }

                default -> {
                    System.out.println("ERRO! OPÇÃO INCORRETA");
                    Ferramentas.Delay(1500);
                    Ferramentas.limparTerminal();
                }
            }
        }
    }
}
