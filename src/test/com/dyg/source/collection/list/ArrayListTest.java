package com.dyg.source.collection.list;

import com.dyg.source.SourceApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * ArrayListTest 类是 ArrayList测试类
 *
 * @author dongyinggang
 * @date 2020/9/17 17:16
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SourceApplication.class)
public class ArrayListTest {

    //通过匿名内部类的方式初始化
    private ArrayList<String> testList = new ArrayList<String>() {
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

    @Test
    public void trimToSize() {
        String[] strings = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));
        log.info("初始化10个元素后：size:" + list.size() + ",length:" + list.elementData.length);
        list.add("11");
        log.info("add新增1个元素后：size:" + list.size() + ",length:" + list.elementData.length);
        list.trimToSize();
        log.info("调用trimToSize()后的：size:" + list.size() + ",length:" + list.elementData.length);
        Assert.assertEquals(list.size(), list.elementData.length);
    }

    @Test
    public void toArray() {
        String[] strings = new String[]{"1", "2"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));
        String[] a = new String[]{"a"};
        //模拟a.length<size的情况
        String[] aTo = list.toArray(a);
        log.info("将list的元素写入到a中 {}", Arrays.toString(aTo));
        Assert.assertArrayEquals(aTo, strings);
        String[] b = new String[]{"a", "b", "c", "d"};
        //模拟a.length>size的情况
        String[] bTo = list.toArray(b);
        log.info("将list的元素写入到b中,{}", Arrays.toString(bTo));
        String[] bTarget = new String[]{"1", "2", null, "d"};
        Assert.assertArrayEquals(bTo, bTarget);

    }

    @Test
    public void elementData() {
        Assert.assertEquals("2", testList.elementData(1));

    }
}