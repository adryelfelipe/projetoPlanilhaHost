package Model;

import Services.ComputadorService;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leitor {

    // -- ATRIBUTOS -- //
    private static String caminhoArquivo;
    private static ComputadorService computadorService = new ComputadorService();

    // -- SETTERS E GETTERS -- //
    public static String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public static void setCaminhoArquivo(String caminhoArquivo) {
        Leitor.caminhoArquivo = caminhoArquivo;
    }

    // -- MÉTODOS ESTÁTICOS -- //

    // LÊ O HOSTNAME
    private static ArrayList<String> lerHostname()
    {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminhoArquivo)))
        {
            ArrayList<String> hostNames = new ArrayList<>();

            String hostName;

            while((hostName = bufferedReader.readLine()) != null)
            {
                hostNames.add(hostName);
            }

            return hostNames;
        }
        catch (IOException e)
        {
            System.err.println("Erro ao ler arquivo: "+ caminhoArquivo+": "+ e.getMessage());

            return null;
        }
    }

    // RESGATA IP A PARTIR DO HOSTNAME
    private static String adquireIpv4(String hostName) throws UnknownHostException {
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
    private static String adquireMac(String ipv4)
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

    public static ArrayList<Computador> gerarComputadores() throws UnknownHostException {

        ArrayList<Computador> computadores = new ArrayList<>();

        for(String hostName : lerHostname()) {

            String nome = hostName;
            String ipComputador = adquireIpv4(nome);
            String macComputador = adquireMac(ipComputador);

            if(computadorService.verificarInformacoes(nome, ipComputador, macComputador)) {
                Computador computador = new Computador(nome, ipComputador, macComputador);

                computadores.add(computador);
            }
        }

        return computadores;
    }
}
