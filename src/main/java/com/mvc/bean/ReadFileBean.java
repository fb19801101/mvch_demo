package com.mvc.bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-24 14:34
 */
public class ReadFileBean {
    private String fileName = null;
    private String filesMess = null;

    public ReadFileBean() {
        filesMess = new String();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilesMess() {
        try{
            StringBuffer temp = new StringBuffer();
            if(fileName != null) {
                String strTemp = null;
                FileReader fr = new FileReader(fileName);
                BufferedReader bufr = new BufferedReader(fr);
                while((strTemp = bufr.readLine()) != null) {
                    byte bb[]=strTemp.getBytes();
                    strTemp=new String(bb);
                    temp.append("\n"+strTemp);
                }

                filesMess = "<textarea rows=8 cols=62>"+temp+"</textarea>";
                bufr.close();
                fr.close();
            }
        }
        catch(IOException ee) {
            System.out.print(ee.toString());
        }
        return filesMess;
    }
}