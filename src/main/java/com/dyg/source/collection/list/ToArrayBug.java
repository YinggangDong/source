package com.dyg.source.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ToArrayBug 类是 toArray不能够返回Object[]的bug
 *
 * Bug ID:JDK-6260652
 * 地址：http://bugs.java.com/bugdatabase/view_bug.do?bug_id=6260652
 *
 *
 * @author dongyinggang
 * @date 2020-09-28 08:03
 **/
public class ToArrayBug {

    public static void main(String[] args) {
        //正常定义的list通过toArray()方法可以返回Object数组
        List<String> str1 = new ArrayList<>();
        str1.add("ab");
        str1.add("bc");
        Object[] strs1 = str1.toArray();
        System.out.println("strs1:");
        System.out.println(str1.toString());
        // class [Ljava.lang.Object;
        System.out.println(strs1.getClass());
        // class java.util.ArrayList
        System.out.println(str1.getClass());

        //通过Arrays.asList创建的list,通过toArray()方法会返回 list 的实际运行对象的数组而非Object对象
        List<String> str2 = Arrays.asList(new String[]{"ab", "bc"});
        Object[] strs2 = str2.toArray();
        System.out.println("strs2:");
        System.out.println(str2.toString());
        // class [Ljava.lang.String;
        System.out.println(strs2.getClass());
        // class java.util.Arrays$ArrayList
        System.out.println(str2.getClass());

        //  java.lang.ArrayStoreException
        strs2[0] = new Object();
    }
}
