package com.xiechy.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.Date;

/**
 * Created by chenlichun on 2016/7/25.
 */
public abstract class ExcelRowDataSetter<T> {

    public String prefixName = "templet";

    /**
     * 使用模板行对数据行填充数据
     * @param templateRow 模板行
     * @param dataRow      数据行
     * @param data          数据
     * @param dataIndex         数据列表的序号，从0开始
     */
    public abstract void setData(Row templateRow, Row dataRow, T data, int dataIndex);

    protected void setValue(Row templateRow, Row dataRow, int cellNum, String value) {
        Cell cell = this.getCell(templateRow, dataRow, cellNum);
        if(value == null) {
            cell.setCellValue("");
        } else {
            cell.setCellValue(value);
        }
    }

    protected void setValue(Row templateRow, Row dataRow, int cellNum, Double value) {
        Cell cell = this.getCell(templateRow, dataRow, cellNum);
        if(value == null) {
            cell.setCellValue("");
        } else {
            cell.setCellValue(value);
        }
    }

    protected void setValue(Row templateRow, Row dataRow, int cellNum, Date value) {
        Cell cell = this.getCell(templateRow, dataRow, cellNum);
        if(value == null) {
            cell.setCellValue("");
        } else {
            cell.setCellValue(value);
        }
    }

    protected void setValue(Row templateRow, Row dataRow, int cellNum, Integer value) {
        Cell cell = this.getCell(templateRow, dataRow, cellNum);
        if(value == null) {
            cell.setCellValue("");
        } else {
            cell.setCellValue(value);
        }
    }

    protected void setValue(Row templateRow, Row dataRow, int cellNum, Long value) {
        Cell cell = this.getCell(templateRow, dataRow, cellNum);
        if(value == null) {
            cell.setCellValue("");
        } else {
            cell.setCellValue(value);
        }
    }

    protected Cell getCell(Row templateRow, Row dataRow, int cellNum) {
        Cell templateCell = null;
        if(templateRow != null) {
            templateCell = templateRow.getCell(cellNum);
        }
        Cell cell = dataRow.getCell(cellNum);
        if(null == cell) {
            cell = dataRow.createCell(cellNum);
        }
        if(templateCell != null) {
            cell.setCellStyle(templateCell.getCellStyle());
        }
        return cell;
    }

}
