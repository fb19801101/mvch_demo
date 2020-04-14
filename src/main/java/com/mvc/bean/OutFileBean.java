package com.mvc.bean;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-24 11:36
 */
public class OutFileBean {
    private String fileName = null;
    private String filesMess = null;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilesMess() {
        return filesMess;
    }

    public void setFilesMess(String filesMess) {
        this.filesMess = filesMess;
        try{
            FileOutputStream fOut = new FileOutputStream(fileName);
            BufferedOutputStream bufOut= new BufferedOutputStream(fOut);
            byte b[]=this.filesMess.getBytes();
            bufOut.write(b);
            bufOut.flush();
            bufOut.close();
            fOut.close();}
        catch(Exception e) {
            System.out.print(e.toString());
        }
    }
}
