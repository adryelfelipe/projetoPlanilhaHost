package Services;

import DAO.ExcelDAO;
import Model.Computador;

import java.util.ArrayList;

public class ExcelService {

    // -- ATRIBUTOS -- //
    private ExcelDAO excelDAO = new ExcelDAO();

    // -- MÉTODOS -- //
    public boolean verificarInformacoes(ArrayList<Computador> computadores, String fileName) {
        return !(computadores == null) && !(fileName == null);
    }

    public void gerarExcel(ArrayList<Computador> computadores, String fileName) {

        excelDAO.saveInventory(computadores, fileName);
    }
}
