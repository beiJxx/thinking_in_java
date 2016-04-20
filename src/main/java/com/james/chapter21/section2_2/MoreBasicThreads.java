/*
 * 文 件 名:  MoreBasicThreads.java
 * 版    权:  Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 创 建 人:  james
 * 创建时间:  2016年4月20日
 */
package com.james.chapter21.section2_2;

import com.james.chapter21.section2_1.LiftOff;

/**
 * 添加更多线程
 *  
 * @author  james
 * @version  [V1.00, 2016年4月20日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public class MoreBasicThreads
{
    public static void main(String[] args)
    {
        for(int i = 0; i < 5; i++)
        {
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for liftoff");
    }
}
