package com.zdw;

import org.testng.annotations.Test;

import java.io.*;

public class WriteFileTest {

    @Test
    public void writeTest() throws Exception{

        String pathname = "D:\\data-bak\\test.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
        File filename = new File(pathname); // 要读取以上路径的input。txt文件
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = "";

        File writename = new File("D:\\data-bak\\output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
        writename.createNewFile(); // 创建新文件
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));

        while ((line = br.readLine())!=null) {
            if(line != null && line.length()>0){
                line = line.replace("IdCardGenerator.areaCode.put(","")
                        .replace(");","")
                        .replace("\"","")
                        .replace(" ","");
                System.out.println(line);
                if(line != null && line.length()>0){
                    String[] strs = line.split(",");
                    out.write("AREA_CODE.put("+Integer.parseInt(strs[1])+",\""+strs[0].replace("/\\s+/", "")
                            .replace(" ","")
                            .replace("　","")
                            .replace("\t\t","")
                            .replace("(*)","")+"\");" +"\r\n");
                }
            }
        }

        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件
    }

}
