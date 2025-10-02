package Model;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leitor {

    // -- ATRIBUTO ESTÁTICO -- //
    private static String caminhoArquivo;

    // -- SETTERS E GETTERS -- //
    public static String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public static void setCaminhoArquivo(String caminhoArquivo) {
        Leitor.caminhoArquivo = caminhoArquivo;
    }

    // -- MÉTODOS ESTÁTICOS -- //

    // LÊ O HOSTNAME
    public static void lerHostname()
    {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminhoArquivo)))
        {
            String hostName;

            while((hostName = bufferedReader.readLine()) != null)
            {
                String ip = adquireIpv4(hostName);
                String mac = adquireMac(ip);

                System.out.println(hostName+" || "+ip+ " || "+mac );
            }
        }
        catch (IOException e)
        {
            System.err.println("Erro ao ler arquivo: "+ caminhoArquivo+": "+ e.getMessage());
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

    // RESGATA O MAC A PARTIR DO Ipv4
    public static String adquireMac(String ipv4)
    {
        try
        {
            ProcessBuilder pb = new ProcessBuilder("arp", "-a", ipv4);
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while((line = reader.readLine()) != null)
            {
                String regex = "(?:[0-9a-fA-F]{1,2}[:-]){5}[0-9a-fA-F]{1,2}";

                Pattern pattern = Pattern.compile(regex);

                Matcher matcher = pattern.matcher(line);

                if(matcher.find())
                {
                    return matcher.group();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler ao resgatar MAC " +e.getMessage());
        }
        return "MAC não encontrado!";
    }
}
