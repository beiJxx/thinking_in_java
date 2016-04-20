/*
 * 文 件 名:  LiftOff.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年4月20日
 */
package com.james.chapter21.section2_1;

/**
 * 定义任务
 * 实现Runnable并编写run()方法
 *  
 * @author  james
 * @version  [V1.00, 2016年4月20日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class LiftOff implements Runnable
{

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}
    
    /** 
     * <默认构造函数>
     */
    public LiftOff(int countDown)
    {
        super();
        this.countDown = countDown;
    }

    public String status()
    {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    /**
     * 重写方法
     * @see java.lang.Runnable#run()
     */
    public void run()
    {
        while(countDown -- > 0)
        {
            System.out.println(status());
            //对线程调度器的一种建议(可以将CPU从一个线程转移给另一个线程了)，
            //他在声明：“我已经执行完生命周期中最重要的部分了，此刻正是切换给其他任务执行一段时间的大好时机”
            Thread.yield();
        }
        
    }
    
}
