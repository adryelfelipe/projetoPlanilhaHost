package Model;

public class Computador {

    // -- ATRIBUTOS -- //
    private String hostName;
    private String ipv4;
    private String mac;

    // -- CONSTRUTOR -- //
    public Computador(String hostName, String ipv4, String mac) {
        this.hostName = hostName;
        this.ipv4 = ipv4;
        this.mac = mac;
    }
}
