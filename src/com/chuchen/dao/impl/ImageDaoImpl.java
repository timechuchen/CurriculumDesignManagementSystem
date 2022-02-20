package com.chuchen.dao.impl;

import com.alibaba.druid.util.JdbcUtils;
import com.chuchen.dao.IImageDao;
import com.utils.ImageUtil;
import com.utils.JdbcUtilByDruid;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageDaoImpl implements IImageDao {
    @Override
    public boolean saveImage(String table,String id, String path) {
        Connection con = null;
        PreparedStatement pst = null;
        FileInputStream in = null;

        try{
            in = ImageUtil.readImage(path);
            con = JdbcUtilByDruid.getConnection();
            String sql = "update "+table+" set photo = ? where id = ?";
            assert con != null;
            pst = con.prepareStatement(sql);
            pst.setBinaryStream(1,in,in.available());
            pst.setString(2,id);
            int count = pst.executeUpdate();
            if(count > 0){
                return true;
            }else {
                return false;
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            JdbcUtilByDruid.close(null,pst,con);
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean readImage(String table,String id,String targetPath) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;

        try{
            con = JdbcUtilByDruid.getConnection();
            String sql = "select * from "+table+" where id = ?";
            assert con != null;
            pst = con.prepareStatement(sql);
            pst.setString(1,id);

            res = pst.executeQuery();
            while (res.next()){
                InputStream in = res.getBinaryStream("photo");
                ImageUtil.readBin2Image(in,targetPath);
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            JdbcUtilByDruid.close(res,pst,con);
        }
    }
}
