package com.mvc.bean;

import java.io.*;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-24 11:02
 */
public class InFileBean {
    private StringBuffer filesMess = null;
    private String fileName = null;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InFileBean() {
        filesMess = new StringBuffer();
    }

    public StringBuffer getFilesMess() {
        try {
            File f = new File(fileName);
            FileInputStream fInput = new FileInputStream(f);
            int size = fInput.available();
            BufferedInputStream bufInput = new BufferedInputStream(fInput);
            byte b[] = new byte[90];
            int n = 0;
            filesMess.append("文件的字节数是：" + size);
            filesMess.append("<br>文档中的内容是：<br>");
            while((n=bufInput.read(b)) != -1) {
                filesMess.append(new String(b,0,n));
            }
            bufInput.close();
            fInput.close();
        }
        catch(Exception e) {
            filesMess.append("读文件发生错误！");
        }

        return filesMess;
    }
}