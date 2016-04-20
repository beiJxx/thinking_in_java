/*
 * 文 件 名: CallableDemo.java
 * 版 权: Copyright YYYY-YYYY, All rights reserved
 * 描 述: <描述>
 * 创 建 人: james
 * 创建时间: 2016年4月20日
 */
package com.james.chapter21.section2_4;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 从任务中产生返回值
 * 实现Callable接口可产生返回值，调用起call()方法
 * 
 * @author james
 * @version [V1.00, 2016年4月20日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class CallableDemo
{
    public static void main(String[] args)
        throws InterruptedException, ExecutionException
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        
        for (int i = 0; i < 5; i++)
        {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results)
        {
            System.out.println(fs.get());
        }
        
    }
}

class TaskWithResult implements Callable<String>
{
    private int id;
    
    /**
     * <默认构造函数>
     */
    public TaskWithResult(int id)
    {
        super();
        this.id = id;
    }
    
    /**
     * 重写方法
     * 
     * @return
     * @throws Exception
     * @see java.util.concurrent.Callable#call()
     */
    public String call()
        throws Exception
    {
        return "result of TaskWithResult " + id;
    }
}
