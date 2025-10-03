package Views;

import Ferramentas.Ferramentas;
import Model.Computador;
import Model.Leitor;
import Services.ComputadorService;
import Services.ExcelService;
import Services.LeitorService;

import java.net.UnknownHostException;
import java.util.ArrayList;

public class MenuLeitor {

    // -- ATRIBUTOS -- //
    private static LeitorService leitorService = new LeitorService();
    private static ExcelService excelService = new ExcelService();

    // -- Métodos -- //
    public static void menuLeitor() throws UnknownHostException {
        {
            if(leitorService.podeLer()) {

                System.out.println("-----------");
                System.out.println("MENU LEITOR");
                System.out.println("-----------");

                System.out.println(); // pula linha

                System.out.print("CAMINHO ARQUIVO: " + Leitor.getCaminhoArquivo());

                ArrayList<Computador> computadores = new ArrayList<>();
                computadores = Leitor.gerarComputadores();

                for(Computador computador : computadores) {
                    System.out.println("HOSTNAME: " + computador.getHostName());
                    System.out.println("IPV4: " + computador.getIpv4());
                    System.out.println("MAC: " + computador.getMac());

                    System.out.println();
                }

                System.out.println(); // pula linha

                System.out.print("DIGITE O CAMINHO DO ARQUIVO EXCEL: ");
                String caminhoExcel = Ferramentas.lerCaminho();

                if(excelService.verificarInformacoes(computadores, caminhoExcel)) {
                    excelService.gerarExcel(computadores, caminhoExcel);
                }

                System.out.println("GERANDO EXCEL...");
                Ferramentas.Delay(2500);

                System.out.println(); // pula linha

                System.out.println("EXCEL GERADO!!!");

            } else {
                System.out.println("ERRO! NÃO Á UM CAMINHO DE ARQUIVO VÁLIDO");

                Ferramentas.Delay(700);
            }

            Ferramentas.limparTerminal();
        }
    }
}
