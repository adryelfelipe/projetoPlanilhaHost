package Model;

import java.io.*;
import java.net.*;
import java.util.*;

public class Leitor {

    // -- MÉTODOS ESTÁTICOS -- //

    // LÊ O HOSTNAME
    public static void lerHostname() {

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
