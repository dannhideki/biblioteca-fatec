package br.gov.sp.centropaulasouza.biblioteca.utils;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Daniel Hideki
 */
public class ImportaXLS {

    private HashMap<String, String[]> livroMap = new HashMap<>();

    public void processAll(String path) {
        try {

            List<String> ref = new ArrayList<>();
            // Leitura
            FileInputStream fi = new FileInputStream(new File(path));

            // Carregando workbook
            XSSFWorkbook wb = new XSSFWorkbook(fi);

            // Selecionando a primeira aba
            XSSFSheet s = wb.getSheetAt(0);

            String[] referencias = {"A1", "A18", "A41", "A57", "A73", "A274", "A281", "A314", "A379", "A760", "A801", "A822", "A848", "A859", "A892", "A1151", "A1207", "A1531", "A1586", "A1647", "A1692", "A1704", "A1713"};

            for (String referencia : referencias) {
                CellReference cellReference = new CellReference(referencia);
                Row row = s.getRow(cellReference.getRow());
                Cell cell = row.getCell(cellReference.getCol());
                ref.add(cell.getStringCellValue());
            }

            int i = 0;
            // Fazendo um loop em todas as linhas
            for (Row rowFor : s) {

                // FAzendo loop em todas as colunas
                for (Cell cellFor : rowFor) {
                    try {
                        // Verifica o tipo de dado
                        if (cellFor.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            // Mostrar numerico
                            System.out.println(cellFor.getNumericCellValue());

                        } else {
                            if ( !cellFor.getStringCellValue().equals("Título")
                                    && !cellFor.getStringCellValue().equals("Autor(es)")
                                    && !cellFor.getStringCellValue().equals("Editora")
                                    && !cellFor.getStringCellValue().equals("Qtdade")) {
                                System.out.println(cellFor.getStringCellValue());

                            }
                        }
                    } catch (Exception e) {
                        // Mostrar Erro
                        System.out.println(e.getMessage());
                    }
                    i++;
                }
                // Mostrar pulo de linha
                System.out.println("------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        File xls = new File("/home/hideki/Documents/CATÁLOGO_DE_LIVROS.xlsx");

        new ImportaXLS().processAll(xls.getPath());
    }
}
