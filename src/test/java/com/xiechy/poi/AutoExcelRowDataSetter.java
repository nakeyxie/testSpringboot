package com.xiechy.poi;

import com.xiechy.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by xiechy on 2018-6-14
 * 自动化DataSetter(注意使用时要指定具体对象T)
 */
public class AutoExcelRowDataSetter<T> extends  ExcelRowDataSetter<T> {

    private static final Logger log = Logger.getLogger(AutoExcelRowDataSetter.class);

    @Override
    public void setData(Row templateRow, Row dataRow, T data, int dataIndex) {
        String[] fields = PropertyUtils.getAllFieldNames(data);
        for (int i = 0; i < fields.length; i++) {
            String value = PropertyUtils.getStrProperty(data, fields[i]);
            this.setValue(templateRow, dataRow, i, value);
        }
    }

}
