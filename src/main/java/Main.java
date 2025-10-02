import Model.Leitor;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.*;


public class Main {


    public static void main(String[] args) throws UnknownHostException {
        String caminhoArquivo = "C:/Users/adryel_souza/Downloads/teste.txt";

        Leitor.setCaminhoArquivo(caminhoArquivo);

        System.out.println(Leitor.gerarComputador());
    }
}
