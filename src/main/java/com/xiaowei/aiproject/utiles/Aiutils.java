package com.xiaowei.aiproject.utiles;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Aiutils {
    //设置APPID/AK/SK
    public static final String APP_ID = "你的APPID";
    public static final String API_KEY = "你的API_KEY";
    public static final String SECRET_KEY = "你的SECRET_KEY";

    public static String picToWord(byte[] file){
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        JSONObject res = client.basicGeneral(file, new HashMap<String, String>());
        String wordsData = "";
        JSONArray words_result = res.getJSONArray("words_result");
        for (int i = 0; i < words_result.length(); i++) {
            Object data = words_result.getJSONObject(i).get("words");
            String word = (String)data;
            wordsData += word + " ";
        }
        return wordsData;
    }
    public static void main(String[] args) {


        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
        // 可选：设置网络连接参数
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        String path = "/Users/xxw/Downloads/QQ20211205-223308@2x.png";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        JSONArray words_result = res.getJSONArray("words_result");
        String wordsData = "";
        for (int i = 0; i < words_result.length(); i++) {
            Object data = words_result.getJSONObject(i).get("words");
            String word = (String)data;
            wordsData += word + " ";
        }
        System.out.println(wordsData);
    }
}
