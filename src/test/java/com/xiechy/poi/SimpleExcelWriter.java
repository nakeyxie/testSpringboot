package com.xiechy.poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by chenlichun on 2016/7/22.
 */
public class SimpleExcelWriter {

    private Workbook workbook;

    public SimpleExcelWriter(InputStream template) throws IOException, InvalidFormatException {
         workbook = WorkbookFactory.create(template);
    }

    public <T> void addData(List<T> dataList, ExcelRowDataSetter<T> dataSetter, int startRowIndex) {
        this.addData(dataList, dataSetter, -1, startRowIndex);
    }

    public <T> void  addData(List<T> dataList,ExcelRowDataSetter<T> dataSetter, int templateRowIndex, int startRowIndex) {
        //默认选用sheet 0
        this.addData(0, dataList, dataSetter, templateRowIndex, startRowIndex);
    }

    public <T> void  addData(int sheetIndex, List<T> dataList, ExcelRowDataSetter<T> dataSetter, int templateRowIndex, int startRowIndex) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row templateRow = null;
        if(templateRowIndex > -1) {
            templateRow = sheet.getRow(templateRowIndex);
        }

        for(int i = 0; i < dataList.size(); i++) {
            T data = dataList.get(i);
            Row dataRow = sheet.getRow(startRowIndex+i);
            if(dataRow == null) {
                dataRow = sheet.createRow(startRowIndex+i);
            }
            dataSetter.setData(templateRow,dataRow, data, i);
        }
    }


    public void setValue(int rowIndex, int columnIndex, String value) {
        this.setValue(0, rowIndex, columnIndex, value);
    }

    public void setValue(int rowIndex, int columnIndex, Integer value) {
        this.setValue(0, rowIndex, columnIndex, value);
    }


    public void setValue(int sheetIndex, int rowIndex, int columnIndex, String value) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);
        if(null == row) {
            row = sheet.createRow(rowIndex);
        }
        Cell cell = row.getCell(columnIndex);
        if(null == cell) {
            cell = row.createCell(columnIndex);
        }

        cell.setCellValue(value);
    }

    public void setValue(int rowIndex, int columnIndex, Date value) {
        this.setValue(0, rowIndex, columnIndex, value);
    }

    public void setValue(int sheetIndex, int rowIndex, int columnIndex, Date value) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);
        if(null == row) {
            row = sheet.createRow(rowIndex);
        }
        Cell cell = row.getCell(columnIndex);
        if(null == cell) {
            cell = row.createCell(columnIndex);
        }

        cell.setCellValue(value);
    }

    public void setValue(int sheetIndex, int rowIndex, int columnIndex, Integer value) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);
        if(null == row) {
            row = sheet.createRow(rowIndex);
        }
        Cell cell = row.getCell(columnIndex);
        if(null == cell) {
            cell = row.createCell(columnIndex);
        }

        cell.setCellValue(value);
    }

    public void setSheetName(int sheetIndex, String sheetName) throws IOException {
        workbook.setSheetName(sheetIndex, sheetName);
    }

    public void createSheet(String sheetName) throws IOException {
        workbook.createSheet(sheetName);
    }

    public void write(OutputStream os) throws IOException {
        workbook.write(os);
        try{
            workbook.close();
        } catch (Exception e) {

        }
    }


}
