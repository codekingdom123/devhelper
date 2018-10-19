package com.jk.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * 文件处理相关工具
 */
public class FileTools {
    /**
     * 保存文件内容到文件
     * @param saveFile 文件目录
     * @param array 文件内容
     */
    public static void saveFile(String saveFile, ArrayList<String> array){
        try {
            //文件不存在，则先创建文件
            File file = new File(saveFile);
            if(!file.exists()){
                if(!file.getParentFile().exists()){
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile,true));
            for (String s : array) {
                bw.write(s);
                bw.newLine();
                bw.flush();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载配置文件到Properties对象
     * @param configFile 配置文件路径
     * @return Properties对象
     */
    public static Properties loadConfig(String configFile) {
        InputStream input = null;
        Properties properties = new Properties();
        try {
            input = FileTools.class.getResourceAsStream(configFile);
            properties.load(input);
        } catch (Exception e) {
            System.out.println("配置文件加载失败");
        } finally {
            if(input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return properties;
    }
}
