package Model;

import java.io.*;
import java.net.*;
import java.util.*;

public class Leitor {

    // -- MÉTODOS ESTÁTICOS -- //

    // LÊ O HOSTNAME
    public static void lerHostname(String arquivo)
    {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo)))
        {
            String hostName;

            while((hostName = bufferedReader.readLine()) != null)
            {
                System.out.println(adquireIpv4(hostName));
            }
        }
        catch (IOException e)
        {
            System.err.println("Erro ao ler arquivo: "+ arquivo+": "+ e.getMessage());
        }

    }

    // RESGATA IP A PARTIR DO HOSTNAME
    public static String adquireIpv4(String hostName) throws UnknownHostException {
        try {
            // CRIA UM OBJETO DO TIPO INETADDRESS QUE REPRESENTA O MEU ENDERECO
            InetAddress endereco = InetAddress.getByName(hostName);

            // RETORNA O IP DO MEU ENDERECO
            return endereco.getHostAddress();
        } catch (UnknownHostException e) {

            return "Host não encontrado: " + hostName;
        }
    }
}
