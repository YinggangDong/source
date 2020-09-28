package com.dyg.source.collection.list;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ArrayListInit 类是
 *
 * @author dongyinggang
 * @date 2020-09-28 11:00
 **/
public class ArrayListInit {

    /**
     * 1.initByAsList 方法是 通过AsList(数组)方法进行list的初始化
     *
     * @author dongyinggang
     * @date 2020/9/28 11:04
     */
    private void initByAsList() {
        String[] strings = new String[]{"1", "2"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));
    }

    /**
     * 2.通过匿名内部类的方式初始化(不推荐,典型反面模式)
     */
    private void initByAnonymous() {
        ArrayList<String> testList = new ArrayList<String>() {
            //实际是声明了一个继承ArrayList的匿名内部类,以下实际是匿名内部类的一个代码块
            //这种方式的声明实际不是一个好方案，是一个典型的反面模式（anti-pattern），最重要的是有可能会造成内存泄漏的风险
            // 详情参见：
            // 1.Java中的双大括号初始化:https://blog.csdn.net/Yaokai_AssultMaster/article/details/52188735
            // 2.java-双大括号实例初始化的反模式：https://www.cnblogs.com/wenbronk/p/7000643.html
            {
                add("1");
                add("2");
                add("3");
                System.out.println("通过匿名内部类进行 ArrayList 初始化 {}"
                        + Arrays.toString(elementData));
            }
        };
    }

    /**
     * 3.initByStreamFactory 方法是 使用Stream的工厂方法
     *
     * @author dongyinggang
     * @date 2020/9/28 11:07
     */
    private void initByStreamFactory() {
        ArrayList<String> list = (ArrayList<String>) Stream.of("1", "2", "3")
                .collect(Collectors.toList());
    }

    /**
     * initByCollectionsFactory 方法是 Java 9可以使用Collections的工厂方法
     *
     * @author dongyinggang
     * @date 2020/9/28 11:10
     */
    private void initByCollectionsFactory(){
        //List<String> list = List.of("1","2","3");
        //Set<String> set = Set.of("1", "2", "3");
    }


}
