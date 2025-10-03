package Ferramentas;

import java.util.Scanner;

public class Ferramentas {

    // -- Atributos -- //
    public static Scanner ler = new Scanner(System.in);

    // -- Métodos -- //
    public static String lerCaminho() {

        return ler.nextLine();
    }

    public static int lerOp() {
        int op = ler.nextInt();
        ler.nextLine();

        return op;
    }

    public static void limparTerminal() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void Delay(int delay) {
        try {Thread.sleep(delay); } catch (InterruptedException ex){}
    }
}
