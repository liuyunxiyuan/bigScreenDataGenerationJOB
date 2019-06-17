package com.transun.util;

import java.io.InputStream;
import java.util.Properties;

public class ConfUtil {
    public static Properties properties=null;
    static {
        properties = loadPropertiesFile("application.properties");
    }

    /**
     * @param fullFile 配置文件名
     * @return Properties对象
     */
    private static Properties loadPropertiesFile(String fullFile) {
        if (null == fullFile || fullFile.equals("")){
            throw new IllegalArgumentException("Properties file path can not be null" + fullFile);
        }
        InputStream inputStream = null;
        Properties p =null;

        try {
            inputStream = ConfUtil.class.getResourceAsStream(fullFile);
            if(null == inputStream){
                inputStream = ConfUtil.class.getClassLoader().getResourceAsStream(fullFile);
            }
            if(null == inputStream){
                inputStream = ConfUtil.class.getClassLoader().getResource(fullFile).openStream();
            }
            p = new Properties();
            p.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream){
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return p;
    }
}
