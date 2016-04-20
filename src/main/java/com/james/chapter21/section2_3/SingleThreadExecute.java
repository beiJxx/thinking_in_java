/*
 * 文 件 名:  SingleThreadExecute.java
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
 * 单个线程
 * 确保任意时刻在任何线程中只有唯一的任务在进行
 *  
 * @author  james
 * @version  [V1.00, 2016年4月20日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class SingleThreadExecute
{
    public static void main(String[] args)
    {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i<5;i++)
        {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
