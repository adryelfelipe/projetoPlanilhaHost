package Views;

import Ferramentas.Ferramentas;
import Model.Leitor;
import Services.LeitorService;

import java.awt.*;

public class MenuCaminho {

    // -- ATRIBUTOS -- //
    private static LeitorService leitorService = new LeitorService();

    // -- MÉTODOS -- //

    public static void menuCaminho() {

        System.out.println("------------");
        System.out.println("MENU ARQUIVO");
        System.out.println("------------");

        System.out.println(); // pula linha

        System.out.print("DIGITE O CAMINHO DO ARQUIVO: ");
        String caminhoArquivo = Ferramentas.lerCaminho();

        if(leitorService.verificarCaminho(caminhoArquivo)) {
            Leitor.setCaminhoArquivo(caminhoArquivo);
        }

        Ferramentas.limparTerminal();
    }

}
