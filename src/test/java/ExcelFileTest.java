import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class ExcelFileTest {
    String filepath = System.getProperty("user.dir") + "/drivers/Survey.xlsx";

    @Test
    public void readColumnAFromExcel() {

        try {
            FileInputStream file = new FileInputStream(new File(filepath));

            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell = row.getCell(0); // Column A

                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.println(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                // Cell contains a date
                                Date date = cell.getDateCellValue();
                                System.out.println(date);
                            } else {
                                // Cell contains a numeric value
                                System.out.println(cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        default:
                            System.out.println("Unknown Cell type");
                            break;
                    }
                }
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void readColumnBFromExcel() {
        String filepath = System.getProperty("user.dir") + "/drivers/Survey.xlsx";

        try {
            FileInputStream file = new FileInputStream(new File(filepath));

            Workbook workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell = row.getCell(1);

                if( cell != null) {
                    switch (cell.getCellType()){
                        case STRING:
                            String cellValue = cell.getStringCellValue();
                            if("Rarely (less than once a week)".equals(cellValue)){
                                System.out.println(cellValue);
                            }
                            break;
                        case NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        default:
                            System.out.println("Unknown Cell type");
                            break;
                    }
                }
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readColumnCFromExcel() {

        try {
            FileInputStream file = new FileInputStream(new File(filepath));

            Workbook workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell = row.getCell(2);

                if( cell != null) {
                    switch (cell.getCellType()){
                        case STRING:
                            System.out.println(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        default:
                            System.out.println("Unknown Cell type");
                            break;
                    }
                }
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readColumnBAndPrintAdjacentIFromExcel() {

        try {
            FileInputStream file = new FileInputStream(new File(filepath));

            Workbook workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cellB = row.getCell(1); // Get cell from column B (index 1)

                if (cellB != null && cellB.getCellType() == CellType.STRING) {
                    String cellValueB = cellB.getStringCellValue();
                    if ("Rarely (less than once a week)".equals(cellValueB)) {
                        // Get the adjacent value from column I (index 8)
                        Cell cellI = row.getCell(8);

                        if (cellI != null) {
                            switch (cellI.getCellType()) {
                                case STRING:
                                    System.out.println("Column B: " + cellValueB + " | Column I: " + cellI.getStringCellValue());
                                    break;
                                case NUMERIC:
                                    System.out.println("Column B: " + cellValueB + " | Column I: " + cellI.getNumericCellValue());
                                    break;
                                case BOOLEAN:
                                    System.out.println("Column B: " + cellValueB + " | Column I: " + cellI.getBooleanCellValue());
                                    break;
                                default:
                                    System.out.println("Column B: " + cellValueB + " | Column I: Unknown Cell type");
                                    break;
                            }
                        } else {
                            System.out.println("Column B: " + cellValueB + " | Column I: No value");
                        }
                    }
                }
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
