package DAO;

import Model.Computador;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelDAO
{
    public void saveInventory(List<Computador> data, String fileName)
    {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Relatório de Redes");

        String[] headers = {"HOSTS", "IP", "MAC"};

        Row headerRow = sheet.createRow(0);

        for(int i = 0; i < headers.length; i++)
        {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        int rowNum = 1;

        for(Computador dispositivo : data)
        {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(dispositivo.getHostName());
            row.createCell(1).setCellValue(dispositivo.getIpv4());
            row.createCell(2).setCellValue(dispositivo.getMac());
        }

        for (int i = 0; i < headers.length; i++)
        {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream(fileName))
        {
            workbook.write(fileOut);
            System.out.println("Arquivo Excel criado com sucesso em: "+ fileName);
        }
        catch (IOException e)
        {
            System.err.println("Erro ao salvar o arquivo Excel: "+ e.getMessage());
        }
        finally
        {
            try
            {
                workbook.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }
}
