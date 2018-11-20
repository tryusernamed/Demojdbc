package com.lc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.sql.*;
import java.util.Properties;

public class BaseDao {

    private static String driver = null;

    private static String url = null;

    private static String user = null;

    private static String password = null;

    static{
        init();
    }

    private static void init(){
        Properties prop = new Properties();
        InputStream is = null;
        try{
            is = BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
            prop.load(is);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeAll(ResultSet rs, Statement stmt, Connection connection){
        try{
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (connection != null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static Connection getConnection(){
        try{
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdate(String sql, Object[] param) {
        PreparedStatement stmt = null;
        int count = 0;
        Connection connection = null;
        try {
            connection = getConnection();
            stmt = getConnection().prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    stmt.setObject((i + 1), param[i]);
                }
            }
            count = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, stmt, connection);
        }
        return count;
    }

    public ResultSet executeQuery(String sql, Object[] param){
        PreparedStatement stmt = null;
        Connection connection = null;
        ResultSet rs = null;
        try{
            connection = getConnection();
            stmt = connection.prepareStatement(sql);
            if(param != null){
                for (int i = 0; i < param.length; i++) {
                    stmt.setObject((i + 1), param[i]);
                }
            }
            rs = stmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

}
