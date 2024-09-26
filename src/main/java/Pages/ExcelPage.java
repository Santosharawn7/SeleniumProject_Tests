package Pages;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class ExcelPage {
    private Workbook workbook;

    public ExcelPage(String filepath) throws IOException {
        FileInputStream file = new FileInputStream(new File(filepath));
        this.workbook = new XSSFWorkbook(file);
    }

    public void closeWorkbook() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }

    public void readColumnA(Sheet sheet) {
        for (Row row : sheet) {
            Cell cell = row.getCell(0); // Column A

            if (cell != null) {
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.println(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            Date date = cell.getDateCellValue();
                            System.out.println(date);
                        } else {
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
    }

    public void readColumnB(Sheet sheet) {
        for (Row row : sheet) {
            Cell cell = row.getCell(1); // Column B

            if (cell != null) {
                switch (cell.getCellType()) {
                    case STRING:
                        String cellValue = cell.getStringCellValue();
                        if ("Rarely (less than once a week)".equals(cellValue)) {
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
    }

    public void readColumnC(Sheet sheet) {
        for (Row row : sheet) {
            Cell cell = row.getCell(2); // Column C

            if (cell != null) {
                switch (cell.getCellType()) {
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
    }

    public void readColumnBAndAdjacentI(Sheet sheet) {
        for (Row row : sheet) {
            Cell cellB = row.getCell(1); // Column B

            if (cellB != null && cellB.getCellType() == CellType.STRING) {
                String cellValueB = cellB.getStringCellValue();
                if ("Rarely (less than once a week)".equals(cellValueB)) {
                    // Adjacent value from column I
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
    }

    public Sheet getSheet(int index) {
        return workbook.getSheetAt(index);
    }
}
