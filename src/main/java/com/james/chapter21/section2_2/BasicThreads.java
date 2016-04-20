/*
 * 文 件 名:  BasicThreads.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年4月20日
 */
package com.james.chapter21.section2_2;

import com.james.chapter21.section2_1.LiftOff;

/**
 * Thread类
 * Thread构造器只需一个runnable对象(即LiftOff)
 * 程序会同时运行两个方法(结果中waiting for liftoff先出现)
 *  
 * @author  james
 * @version  [V1.00, 2016年4月20日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class BasicThreads
{
    public static void main(String[] args)
    {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("waiting for liftoff");
    }
}
