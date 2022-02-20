package com.utils;

import java.io.*;

public class ImageUtil {

    /**
     * @param path 存储本地照片的路径
     * @return 返回一个输入流对象
     * @throws FileNotFoundException 文件未找到异常
     */
    public static FileInputStream readImage(String path) throws FileNotFoundException {
        return new FileInputStream(path);
    }

    /**
     * 从表中图片获取输出流
     * @param in 数据库读出的流对象
     * @param targetPath 目标路径（读出的照片存放路径）
     */
    public static void readBin2Image(InputStream in,String targetPath){
        File  file = new File(targetPath);
        String path = targetPath.substring(0,targetPath.lastIndexOf("/"));
        if(!file.exists()){
            new File(path).mkdir();
        }
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = in.read(buf)) != -1){
                fos.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != fos){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
