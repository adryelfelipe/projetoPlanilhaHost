import Model.Leitor;

import java.io.*;
import java.net.InetAddress;
import java.util.regex.*;


public class Main {


    public static void main(String[] args)
    {
        String caminhoArquivo = "C:/Users/gustavo_pelissari150/Desktop/teste.txt";

        Leitor.lerHostname(caminhoArquivo);
    }
}
