package com;

import com.chuchen.dao.IImageDao;
import com.chuchen.dao.impl.ImageDaoImpl;

public class ImageDemo {
    public static void main(String[] args) {
        IImageDao imageDao = new ImageDaoImpl();
        if(imageDao.readImage("teacher","21212","/CDManager/web/upload/hello.jpg")){
            System.out.println("读取成功！！！");
        }else {
            System.out.println("读取失败");
        }
//        if(imageDao.saveImage("student","9811111111","F:\\CDManager\\out\\artifacts\\CDManager_war_exploded\\upload\\苍老师.jpg")){
//            System.out.println("插入成功！！！");
//        }else {
//            System.out.println("插入失败！！！");
//        }
    }
}
