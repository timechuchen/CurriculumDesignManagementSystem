package com.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtilByDruid {
    static DataSource dataSource = null;
    static {
        try {
            File directory = new File("");//参数为空
            String courseFile = directory.getCanonicalPath() ;
            String path = courseFile+"\\druid.properties";
            Properties properties = new Properties();
            properties.load(new FileInputStream(path));
            //创建一个指定参数的数据库连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @return 获取通过德鲁伊连接池的连接对象
     */
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param set 返回集合对象
     * @param statement 执行对象
     * @param connection 连接对象
     */
    public static void close(ResultSet set, Statement statement, Connection connection){
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
