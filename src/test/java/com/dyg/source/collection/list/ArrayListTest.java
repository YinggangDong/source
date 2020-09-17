package com.dyg.source.collection.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
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
    }

    @Test
    public void ensureCapacity() {
    }

    @Test
    public void size() {
    }
}