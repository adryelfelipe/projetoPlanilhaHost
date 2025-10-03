package Services;

import Model.Leitor;

public class LeitorService {

    public boolean verificarCaminho(String caminhoArquivo) {
        if(!(caminhoArquivo == null) && !(caminhoArquivo.isEmpty())) {

            return true;
        }

        return false;
    }

    public boolean setarCaminho(String caminho) {
        if(verificarCaminho(caminho)) {

            return true;
        }

        return false;
    }

    public boolean podeLer() {
        return !((Leitor.getCaminhoArquivo() == null));
    }
}
