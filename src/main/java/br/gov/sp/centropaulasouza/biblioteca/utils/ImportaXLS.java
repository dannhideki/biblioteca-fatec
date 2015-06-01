package br.gov.sp.centropaulasouza.biblioteca.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Daniel Hideki
 */
public class ImportaXLS {

    //private HashMap<String, String[]> livroMap = new HashMap<>();
    private HashMap<String, Integer> editoraMap = new HashMap<>();
    private HashMap<String, Integer> autorMap = new HashMap<>();

    public void processAll(String path) {
        try {

//            List<String> ref = new ArrayList<>();
            // Leitura
            FileInputStream fi = new FileInputStream(new File(path));

            // Carregando workbook
            XSSFWorkbook wb = new XSSFWorkbook(fi);

            // Selecionando a primeira aba
            XSSFSheet s = wb.getSheetAt(0);

//            String[] referencias = {"A1", "A18", "A41", "A57", "A73", "A274", "A281", "A314", "A379", "A760", "A801", "A822", "A848", "A859", "A892", "A1151", "A1207", "A1531", "A1586", "A1647", "A1692", "A1704", "A1713"};
//            System.out.println("########################################################################################");
//            System.out.println("#############   Criacao de scripts para a criacao da biblioteca     ####################");
//            System.out.println("#############                   Categoria                           ####################");
//            System.out.println("########################################################################################");
//            System.out.println("");
//            for (String referencia : referencias) {
//                CellReference cellReference = new CellReference(referencia);
//                Row row = s.getRow(cellReference.getRow());
//                Cell cell = row.getCell(cellReference.getCol());
//                categoriaMap.put(id, cell.getStringCellValue());
//                //System.out.println("insert into CATEGORIA (ativo,dataCadastro,descricao) values (1,curdate(),'" + cell.getStringCellValue() + "');");
//            }
//            System.out.println("");
//            System.out.println("###################################################################");
//            System.out.println("#############   Fim da categoria               ####################");
//            System.out.println("###################################################################");
//            System.out.println("");
            Integer[] indices = {1, 18, 41, 57, 73, 274, 281, 314, 379, 760, 801, 822, 848, 859, 892, 1151, 1207, 1531, 1586, 1647, 1692, 1704, 1713};
            int i = 1;
            int incrementador = 0;
            int id = 0;
            int idEditora = 0;
            int idAutor = 0;
            // Fazendo um loop em todas as linhas
            for (Row rowFor : s) {
                String titulo;
                
                StringBuilder sql = new StringBuilder();
                sql.append("insert into ACERVO (descricao,codigo_categoria,codigo_autor,codigo_editora,numeroCopias) values(");
                // FAzendo loop em todas as colunas
                for (Cell cellFor : rowFor) {
                    try {
                        if (i == indices[incrementador] && incrementador <22) {
                            id++;
                            incrementador++;
                        }
                        
                        // Verifica o tipo de dado
                        if (cellFor.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            // Mostrar numerico
                            sql.append(String.valueOf(cellFor.getNumericCellValue()).substring(0,1)).append(");");
                            //System.out.println("Qtd.: " + cellFor.getNumericCellValue());

                        } else {
                            if (!cellFor.getStringCellValue().equals("Título")
                                    && !cellFor.getStringCellValue().equals("Autor(es)")
                                    && !cellFor.getStringCellValue().equals("Editora")
                                    && !cellFor.getStringCellValue().equals("Qtdade")) {

                                if (cellFor.getColumnIndex() == 0) {
                                    titulo = cellFor.getStringCellValue();
                                    sql.append("'").append(titulo).append("',");
                                    //System.out.println("Titulo : " + cellFor.getStringCellValue());
                                    sql.append(id).append(",");
                                }
                                if (cellFor.getColumnIndex() == 1) {
                                    if (!autorMap.containsKey(cellFor.getStringCellValue())) {
                                        autorMap.put(cellFor.getStringCellValue(),idAutor);
                                        //System.out.println("Autor : " + cellFor.getStringCellValue());
                                        idAutor++;
                                    }
                                    sql.append(autorMap.get(cellFor.getStringCellValue())).append(",");
                                }
                                if (cellFor.getColumnIndex() == 2) {
                                    if (!editoraMap.containsKey(cellFor.getStringCellValue())) {
                                        editoraMap.put(cellFor.getStringCellValue(),idEditora);
                                        //System.out.println("Editora : " + cellFor.getStringCellValue());
                                        idEditora++;
                                    }
                                    sql.append(editoraMap.get(cellFor.getStringCellValue())).append(",");
                                }
                            }
                        }
                    } catch (Exception e) {
                        // Mostrar Erro
                        e.printStackTrace();
                    }

                }
                // Mostrar pulo de linha
                //System.out.println("------------------------");
                i++;
                System.out.println(sql.toString());
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("######  Sql da editora      ########");
        for (Map.Entry<String, Integer> entrySet : editoraMap.entrySet()) {
            String key = entrySet.getKey();
            System.out.println("insert into EDITORA (descricao, ativo) values('"+key+"',1);");
        }
        System.out.println("######  Fim Sql da editora  ########");
        System.out.println("");
        System.out.println("######  Sql da autor        ########");
        for (Map.Entry<String, Integer> entrySet : autorMap.entrySet()) {
            String key = entrySet.getKey();
            System.out.println("insert into AUTOR (descricao, ativo) values('"+key+"',1);");
        }
        System.out.println("######  Fim Sql da autor  ########");
    }

    public static void main(String args[]) {///Users/hideki/Documents/Fatec/Projeto Biblioteca
        File xls = new File("/Users/hideki/Documents/Fatec/Projeto Biblioteca/CATÁLOGO_DE_LIVROS.xlsx");

        new ImportaXLS().processAll(xls.getPath());
    }
}
