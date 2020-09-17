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

    @Test
    public void trimToSize() {
        String[] strings = new String[]{"1","2","3","4","5","6","7","8","9","10"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));
        log.info("初始化10个元素后：size:" + list.size()+",length:"+list.elementData.length);
        list.add("11");
        log.info("add新增1个元素后：size:" + list.size()+",length:"+list.elementData.length);
        list.trimToSize();
        log.info("调用trimToSize()后的：size:" + list.size()+",length:"+list.elementData.length);
        Assert.assertEquals(list.size(),list.elementData.length);
    }
}