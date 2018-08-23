package cn.luutqf.webdemo01.demo;

import java.util.Arrays;

/**
 * @Author : ZhenYang
 * @Despriction :
 * @Date: Created in 2018/7/23 19:56
 * @Modify By:
 */
public class Demo {
    private String[] strings;

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "strings=" + Arrays.toString(strings) +
                '}';
    }
}
