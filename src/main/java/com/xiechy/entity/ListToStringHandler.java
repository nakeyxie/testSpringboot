package com.xiechy.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ListToStringHandler
 * @Description list转换string
 * https://blog.csdn.net/sinat_38073073/article/details/110136015
 * @Author R&D-VAL SZ nakey.xie
 * @Date 2021/7/2 9:12
 */
public class ListToStringHandler extends BaseTypeHandler<List> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List list, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JSON.toJSONString(list));
    }

    @Override
    public List getNullableResult(ResultSet resultSet, String s) throws SQLException {
        JSONArray jsonArray = JSONArray.parseArray( resultSet.getString(s));
        return jsonArray;
    }

    @Override
    public List getNullableResult(ResultSet resultSet, int i) throws SQLException {
        JSONArray jsonArray = JSONArray.parseArray( resultSet.getString(i));
        return jsonArray;
    }

    @Override
    public List getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        JSONArray jsonArray = JSONArray.parseArray( callableStatement.getString(i));
        return jsonArray;
    }
}

