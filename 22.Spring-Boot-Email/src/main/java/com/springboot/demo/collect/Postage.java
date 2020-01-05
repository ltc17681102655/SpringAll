package com.springboot.demo.collect;
/**
 * @auther: ltc
 * @date: 2020/1/5 23:06
 * @description:
 */


import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Postage {
    public static void main(String[] args) throws Exception {// 本程序内部异常过多为了简便，不一Try，直接抛给虚拟机
        long StartTime = System.currentTimeMillis();
        System.out.println("--     欢迎使用小刘简易网页爬虫程序      --");
        System.out.println("");
        System.out.println("--请输入正确的网址如http：//www.baidu.com--");
//        Scanner input = new Scanner(System.in);// 实例化键盘输入类

//        String webaddress = input.next();// 创建输入对象
        File file = new File("E:" + File.separator + "爬虫邮箱统计文本.txt");// 实例化文件类对象

        // 并指明输出地址和输出文件名

        String webaddress = "https://www.baidu.com/";

        Writer outWriter = new FileWriter(file);// 实例化outWriter类

        URL url = new URL(webaddress);// 实例化URL类。

        URLConnection conn = url.openConnection();// 取得链接

        BufferedReader buff = new BufferedReader(new InputStreamReader(

                conn.getInputStream()));// 取得网页数据

        String line = null;
        int i = 0;
        String regex = "\\w+@\\w+(\\.\\w+)+";// 声明正则，提取网页前提

        Pattern p = Pattern.compile(regex);// 为patttern实例化

        outWriter.write("该网页中所包含的的邮箱如下所示:\r\n");
        while ((line = buff.readLine()) != null) {

            Matcher m = p.matcher(line);// 进行匹配

            while (m.find()) {
                i++;
                outWriter.write(m.group() + ";\r\n");// 将匹配的字符输入到目标文件
            }
        }
        long StopTime = System.currentTimeMillis();
        String UseTime = (StopTime - StartTime) + "";
        outWriter.write("--------------------------------------------------------\r\n");
        outWriter.write("本次爬取页面地址：" + webaddress + "\r\n");
        outWriter.write("爬取用时：" + UseTime + "毫秒\r\n");
        outWriter.write("本次共得到邮箱：" + i + "条\r\n");
        outWriter.write("****谢谢您的使用****\r\n");
        outWriter.write("--------------------------------------------------------");
        outWriter.close();// 关闭文件输出操作
        System.out.println(" —————————————————————\t");
        System.out.println("|页面爬取成功，请到E盘根目录下查看test文档|\t");
        System.out.println("|                                         |");
        System.out.println("|如需重新爬取，请再次执行程序,谢谢您的使用|\t");
        System.out.println(" —————————————————————\t");
    }
}