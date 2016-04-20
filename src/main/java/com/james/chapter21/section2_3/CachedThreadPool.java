/*
 * 文 件 名:  CachedThreadPool.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年4月20日
 */
package com.james.chapter21.section2_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.james.chapter21.section2_1.LiftOff;

/**
 * 使用Executor
 * Executor代替MoreBasicThreads.java中显示的创建Thread对象
 * ExecutorService知道如何构建恰当的上下文来执行Runnable对象
 * CachedThreadPool为每个任务都创建一个线程
 *  
 * @author  james
 * @version  [V1.00, 2016年4月20日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class CachedThreadPool
{
    public static void main(String[] args)
    {
        //使用静态的Executor方法创建
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i< 5; i++)
        {
            exec.execute(new LiftOff());
        }
        //可防止新任务(即main线程)被提交给这个Executor
        exec.shutdown();
    }
}
