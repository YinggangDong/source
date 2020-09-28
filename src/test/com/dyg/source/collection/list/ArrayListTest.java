package com.dyg.source.collection.list;

import com.dyg.source.SourceApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    private static ArrayList<String> initList = new ArrayList<>();
    static {
        initList.add("1");
        initList.add("2");
        initList.add("3");
    }


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

        Assert.assertEquals("2", initList.elementData(1));

    }

    @Test
    public void get() {
        //测试下标为负数抛出的ArrayIndexOutOfBoundsException异常
        try{
            log.info(initList.get(-1));
        }catch (ArrayIndexOutOfBoundsException e){
            log.error("ArrayIndexOutOfBoundsException异常信息",e);
            Assert.assertEquals("-1",e.getMessage());
        }
        //测试下标越界抛出的IndexOutOfBoundsException异常结果
        try{
            log.info(initList.get(100));
        }catch (IndexOutOfBoundsException e){
            log.error("IndexOutOfBoundsException异常信息",e);
            Assert.assertEquals("Index: 100, Size: "+ initList.size(),e.getMessage());
        }
        Assert.assertEquals("2",initList.get(1));
    }

    @Test
    public void add() {
        //测试add调用链
        initList.add("4");
    }
}