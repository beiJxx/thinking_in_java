/*
 * 文 件 名:  MainThread.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年4月20日
 */
package com.james.chapter21.section2_1;

/**
 * LiftOff的run任务不是单独的线程驱动的，它是在main中调用的
 * 实际上人就是用了线程，即总是分配给main()的线程
 *  
 * @author  james
 * @version  [V1.00, 2016年4月20日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class MainThread
{
    public static void main(String[] args)
    {
        LiftOff launch = new LiftOff();
        launch.run();
        System.out.println("111111111");
    }
}
