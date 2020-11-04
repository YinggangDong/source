package com.dyg.source.collection.map;

import java.util.HashMap;

/**
 * HashMapDemo 类是 hashMap的demo类
 *
 * @author dongyinggang
 * @date 2020-11-04 19:57
 **/
public class HashMapDemo {

    public static void main(String[] args) {
        replaceDemo();
    }

    private static void replaceDemo(){

        HashMap map = new HashMap();
        map.put(1, "value1");
        map.replace(1,"value2");
        map.forEach((k,v)-> System.out.println("key:"+k+" value:" + v));
    }
}
