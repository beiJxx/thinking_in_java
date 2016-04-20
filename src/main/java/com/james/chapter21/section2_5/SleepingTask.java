/*
 * 文 件 名: SleepingTask.java
 * 版 权: Copyright YYYY-YYYY, All rights reserved
 * 描 述: <描述>
 * 创 建 人: james
 * 创建时间: 2016年4月20日
 */
package com.james.chapter21.section2_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.james.chapter21.section2_1.LiftOff;

/**
 * 休眠
 * sleep
 * sleep 方法允许较低优先级的线程获得运行机会
 * yield 方法只会让出同等优先级的线程，低优先级的线程只能等高优先级的执行完才能执行
 * 
 * @author james
 * @version [V1.00, 2016年4月20日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class SleepingTask extends LiftOff
{
    /**
     * 重写方法
     * 
     * @see com.james.chapter21.section2_1.LiftOff#run()
     */
    public void run()
    {
        try
        {
            while (countDown-- > 0)
            {
                System.out.println(status());
                // Thread.sleep(1);
                TimeUnit.MICROSECONDS.sleep(100);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("interrupted");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new SleepingTask());
        exec.shutdown();
    }
}
