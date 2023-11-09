package com.akikun.demo.file;

import java.io.File;

/**
 * @author 李俊秋(龙泽)
 */
public class FileDemo {


    public static void main(String[] args) {
        String ori_fileName = "444.sql";
        String substring = ori_fileName.substring(ori_fileName.lastIndexOf("."), ori_fileName.length());
        if (substring.equals(".sql")) {
            System.out.println(ori_fileName);
        }


    }

}
