package com.mvc.bean;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-24 14:49
 */
public class RandomFileBean {
    private String fileName = null;
    private long filePointer;
    private long fileLength;
    private String filesMess = null;

    public long getFilePointer() {
        return filePointer;
    }

    public RandomFileBean() {
        filesMess = new String();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileLength() {
        return fileLength;
    }

    public String getFilesMess() {
        try{
            StringBuffer buf = new StringBuffer();
            RandomAccessFile rf = new RandomAccessFile(fileName,"rw");
            fileLength = rf.length();
            filePointer = rf.getFilePointer();
            String strtemp = null;
            byte bb[] = new byte[100];
            while((strtemp = rf.readLine()) != null) {
                bb = strtemp.getBytes("ISO-8859-1");
                strtemp = new String(bb);
                buf.append("\\n"+strtemp);
            }
            filesMess = "文件内容是：<br>"+"<textarea cols=40 rows=6>"+buf+"</textarea>";
            filesMess += "<br>文件读取完毕，当前文件指针位置在："+rf.getFilePointer()+"<br>\\";
            rf.close();
        }
        catch(FileNotFoundException exp) {
            filesMess = "文件不存在！";
            System.out.print(exp.toString());
        }
        catch(IOException ee) {
            filesMess = "文件读写错误";
            System.out.print(ee.toString());
        }

        return filesMess;
    }
}
