import DAO.ExcelDAO;
import Model.Leitor;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.*;


public class Main {


    public static void main(String[] args) throws UnknownHostException {
        String caminhoArquivo = "C:/Users/gustavo_pelissari150/Downloads/teste.txt";
        String arquivoExcel = "C:/Users/gustavo_pelissari150/Documents/Relatório_Excel_v2.xlsx";

        Leitor.setCaminhoArquivo(caminhoArquivo);

        ExcelDAO.saveInventory(Leitor.gerarComputadores(), arquivoExcel);
    }
}
