package Services;

public class ComputadorService {

    public boolean verificarInformacoes(String hostName, String ipv4, String mac) {

        return (!hostName.isEmpty() && !ipv4.isEmpty() & !mac.isEmpty());
    }
}
