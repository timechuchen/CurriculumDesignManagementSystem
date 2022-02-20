package com.chuchen.dao;

public interface IImageDao {

    /**
     * 将图片存到数据库中
     * @param id 要存储给id的人
     * @param path 存储的照片路径
     * @return true为存储成功
     */
    boolean saveImage(String table,String id,String path);

    /**
     * 将数据库照片读取出来
     * @param targetPath 读取出的照片路径
     * @return true 读取成功
     */
    boolean readImage(String table,String id,String targetPath);
}
