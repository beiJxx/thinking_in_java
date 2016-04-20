/*
 * 文 件 名:  FixedThreadPool.java
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
 * 有限的线程集
 *  
 * @author  james
 * @version  [V1.00, 2016年4月20日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class FixedThreadPool
{

    public static void main(String[] args)
    {
        long lasting = System.currentTimeMillis();// 效率检测
        
        ExecutorService exec = Executors.newFixedThreadPool(1);
        for(int i = 0; i< 5; i++)
        {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
        
        long lasting2 = System.currentTimeMillis();
        System.out.println("用时" + (lasting2 - lasting) + "ms");
    }

}
