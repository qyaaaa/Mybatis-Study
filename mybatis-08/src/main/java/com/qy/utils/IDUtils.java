package com.qy.utils;

import org.junit.Test;

import java.util.UUID;

public class IDUtils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test1(){
        System.out.println(IDUtils.getId());
    }
}
