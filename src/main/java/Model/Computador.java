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

    // -- GETTERS E SETTERS -- //
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }
}
