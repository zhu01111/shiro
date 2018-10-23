/**
 * FileName:         Singleton.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年10月19日     下午4:09:10
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年10月19日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.shiro.utils;

/**
 * @ClassName:       Singleton
 * @author:          zhuWeichao
 * @date:            2018年10月19日        下午4:09:10
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
