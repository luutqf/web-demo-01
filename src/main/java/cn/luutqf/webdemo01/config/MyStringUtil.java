package cn.luutqf.webdemo01.config;

/**
 * @Author : ZhenYang
 * @Despriction :
 * @Date: Created in 2018/7/24 18:31
 * @Modify By:
 */
public class MyStringUtil {
    public static String getTable(String val){
        String start = "<div";
        String stop = "</script>";
        int s = val.indexOf(start);
        int st = val.indexOf(stop);
        return val.substring(s,st);
    }
}
