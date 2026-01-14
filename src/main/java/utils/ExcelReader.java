package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelReader {

    // =========================
    // READ EXCEL AS WORKBOOK
    // =========================

    private static Workbook getWorkbook(String filePath) {
        try {
            return new XSSFWorkbook(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Unable to read Excel file: " + filePath, e);
        }
    }

    // =========================
    // READ SHEET AS LIST OF HASHMAP
    // First row = HEADER
    // =========================

    public static List<HashMap<String, String>> getDataAsList(
            String filePath,
            String sheetName
    ) {
        Workbook workbook = getWorkbook(filePath);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException("Sheet not found: " + sheetName);
        }

        List<HashMap<String, String>> dataList = new ArrayList<>();
        Row headerRow = sheet.getRow(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row currentRow = sheet.getRow(i);
            HashMap<String, String> rowData = new HashMap<>();

            for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                String key = getCellValue(headerRow.getCell(j));
                String value = getCellValue(currentRow.getCell(j));
                rowData.put(key, value);
            }
            dataList.add(rowData);
        }
        return dataList;
    }

    // =========================
    // READ SINGLE ROW BY TEST CASE NAME
    // =========================

    public static HashMap<String, String> getRowData(
            String filePath,
            String sheetName,
            String testCaseName
    ) {
        List<HashMap<String, String>> dataList = getDataAsList(filePath, sheetName);

        for (HashMap<String, String> row : dataList) {
            if (row.containsValue(testCaseName)) {
                return row;
            }
        }
        throw new RuntimeException("Test case not found: " + testCaseName);
    }

    // =========================
    // READ CELL VALUE (SAFE)
    // =========================

    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell).trim();
    }

    // =========================
    // GET ROW COUNT
    // =========================

    public static int getRowCount(String filePath, String sheetName) {
        Workbook workbook = getWorkbook(filePath);
        return workbook.getSheet(sheetName).getLastRowNum();
    }

    // =========================
    // GET COLUMN COUNT
    // =========================

    public static int getColumnCount(String filePath, String sheetName) {
        Workbook workbook = getWorkbook(filePath);
        return workbook.getSheet(sheetName).getRow(0).getLastCellNum();
    }
}
