package com.jsonExample;
/**
 * json 写 和读
 *    循环写入方式
 */

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class helloJson {
    public static void main(String[] args) {
        //创建jsaon
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a",123);
        System.out.println(jsonObject.get("a"));
        //创建json数组
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject);
        System.out.println(jsonArray.toString());
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("hello",jsonArray);

        //写入本地。很方便
        try {
            FileWriter fw = new FileWriter("c://工作//a.txt");
            fw.write(jsonObject1.toString());
            fw.close();
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //从本地读取json文件
        try {
            FileReader fileReader = new FileReader("c://工作//a.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String stjson = "";
            while(true){
                String str = br.readLine();
                if(str==null){
                    break;
                }
                stjson +=str;
            }
            JSONObject jsonObject2 = new JSONObject(stjson);
            System.out.println(jsonObject2.toString());
            JSONArray jsonArray1 = jsonObject2.getJSONArray("hello");
            System.out.println(jsonArray1.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
