import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;

public class CityDuplicateRemover {
    public static void removeDuplicates(String inputFile, String outputFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook workbook = new XSSFWorkbook(fis)) {
            
            Sheet sheet = workbook.getSheetAt(0);
            Map<String, Integer> uniqueCoords = new HashMap<>();
            Row headerRow = sheet.getRow(0);
            
            // Find lng and lat columns
            int lngCol = findColumn(headerRow, "lng");
            int latCol = findColumn(headerRow, "lat");
            
            // Create new workbook
            Workbook newWorkbook = new XSSFWorkbook();
            Sheet newSheet = newWorkbook.createSheet();
            
            // Copy header
            copyRow(headerRow, newSheet.createRow(0));
            
            int newRowIdx = 1;
            // Process rows
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) continue;
                
                double lng = currentRow.getCell(lngCol).getNumericCellValue();
                double lat = currentRow.getCell(latCol).getNumericCellValue();
                String key = lng + "," + lat;
                
                if (!uniqueCoords.containsKey(key)) {
                    uniqueCoords.put(key, i);
                    copyRow(currentRow, newSheet.createRow(newRowIdx++));
                }
            }
            
            // Save result
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                newWorkbook.write(fos);
            }
        }
    }
    
    private static int findColumn(Row headerRow, String columnName) {
        for (Cell cell : headerRow) {
            if (columnName.equals(cell.getStringCellValue())) {
                return cell.getColumnIndex();
            }
        }
        throw new IllegalArgumentException("Column " + columnName + " not found");
    }
    
    private static void copyRow(Row source, Row target) {
        for (Cell cell : source) {
            Cell newCell = target.createCell(cell.getColumnIndex());
            switch (cell.getCellType()) {
                case NUMERIC -> newCell.setCellValue(cell.getNumericCellValue());
                case STRING -> newCell.setCellValue(cell.getStringCellValue());
                default -> newCell.setCellValue("");
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            removeDuplicates("dublicates_cities.xlsx", "unique_cities.xlsx");
            System.out.println("Processing complete. Check unique_cities.xlsx");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}