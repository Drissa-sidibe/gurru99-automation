package Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;

public class ExcelUtility {
    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;

    public XSSFCellStyle style;

    String path;

    public ExcelUtility(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        fi= new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowCount;
    }
    public int getCellCount(String sheetName, int rowNum) throws IOException {
        fi =  new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row=sheet.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellCount;
    }
    public String getCellData(String sheetName, int rowNum, int cellNum) throws IOException {
        fi= new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell=row.getCell(cellNum);

        DataFormatter formatter = new DataFormatter();
        String data;
        try {
            data = formatter.formatCellValue(cell);
        }catch (Exception e){
            data="";
        }
        workbook.close();
        fi.close();
        return data;
    }

    public void setCellData(String sheetName, int rowNum, int cellNum, String data) throws IOException {
        File xlFIle = new File(path);
        if(!xlFIle.exists()){
            workbook = new XSSFWorkbook();
            fo=new FileOutputStream(path);
            workbook.write(fo);
        }
        fi= new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        if(workbook.getSheetIndex(sheetName)==-1){
            workbook.createSheet(sheetName);
            sheet=workbook.getSheet(sheetName);

            if(sheet.getRow(rowNum)==null){
                row=sheet.createRow(rowNum);

                cell =row.createCell(cellNum);
                cell.setCellValue(data);
                workbook.close();
                fi.close();
                fo.close();
            }
        }
    }
    public void fillGreenColor(String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
    public void fillRedColor(String sheetName, int rowNum, int colNum) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rowNum);
        cell=row.getCell(colNum);

        style=workbook.createCellStyle();

        style.setFillBackgroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
}

