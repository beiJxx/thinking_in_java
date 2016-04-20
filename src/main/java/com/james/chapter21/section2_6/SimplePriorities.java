/*
 * 文 件 名: SimplePriorities.java
 * 版 权: Copyright YYYY-YYYY, All rights reserved
 * 描 述: <描述>
 * 创 建 人: james
 * 创建时间: 2016年4月20日
 */
package com.james.chapter21.section2_6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 优先级
 * 调度器倾向于让优先权最高的线程执行（优先权不会导致死锁）
 * 绝大多数时间，所有线程应该以默认的优先级运行（试图操纵线程优先级通常是一种错误）
 * @author james
 * @version [V1.00, 2016年4月20日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class SimplePriorities implements Runnable
{
    private int countDown = 5;
    
    private volatile double d;
    
    private int priority;
    
    /**
     * <默认构造函数>
     */
    public SimplePriorities(int priority)
    {
        super();
        this.priority = priority;
    }
    
    /**
     * 重写方法
     * 
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return Thread.currentThread() + ": " + countDown ;
    }
    
    /**
     * 重写方法
     * 
     * @see java.lang.Runnable#run()
     */
    public void run()
    {
        Thread.currentThread().setPriority(priority);
        
        while (true)
        {
            for (int i = 0; i < 100000; i++)
            {
                d += (Math.PI + Math.E) / (double)i;
                if (i % 1000 == 0)
                {
                    Thread.yield();
                }
                System.out.println(this);
                if (--countDown == 0)
                    return;
            }
        }
        
    }
    
    public static void main(String[] args)
    {
        //TODO 按照编程思想page660上所写，优先权高的应该是最先执行，书上的结果是正确的，但实际执行结果却不是这样
        
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
    
}
