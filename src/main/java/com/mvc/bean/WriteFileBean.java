package com.mvc.bean;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-24 14:34
 */
public class WriteFileBean {
    private String fileName = null;
    private String filesMess = null;

    public WriteFileBean() {
        filesMess = new String();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilesMess(String filesMess) {
        this.filesMess = filesMess;
        try{
            if(fileName != null) {
                FileWriter wr = new FileWriter(fileName);
                BufferedWriter bufw = new BufferedWriter(wr);
                bufw.write(this.filesMess);
                bufw.flush();
                bufw.close();
                wr.close();
            }
        }
        catch(IOException ee) {
            System.out.print(ee.toString());
        }
    }
}
