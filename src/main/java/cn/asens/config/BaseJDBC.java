package cn.asens.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/3.
 */
@Component
public class BaseJDBC {
    private static Connection con = null;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    private Connection getConnection()
    {
        if(con==null){
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }


    public void update(String sql) {
        Connection con = getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
            stmt=null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void execute(String sql, List<String> intList, String name)
    {
        Connection con = getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                intList.add(rs.getString(name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeRsAndStmt(rs,stmt);
    }

//
//    public void execute(String sql, List<Integer> intList, String name)
//    {
//        Connection con = getConnection();
//        Statement stmt = null;
//        try {
//            stmt = con.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        ResultSet rs = null;
//        try {
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                intList.add(rs.getInt(name));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        closeRsAndStmt(rs,stmt);
//    }



    private void closeRsAndStmt(ResultSet rs, Statement stmt)
    {
        try {
            if(rs!=null){
                rs.close();
            }
            stmt.close();
            rs=null;
            stmt=null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
