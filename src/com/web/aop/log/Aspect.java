package com.web.aop.log;

import org.aspectj.lang.JoinPoint;  

/** 
 * 定义切面类，将系统中的横切性关注点模块化  
 * @author Wiki.M 
 */  
public class Aspect {  
  
    /** 
     * 定义advice，即切面类中方法具体实现， 这里主要是用于记录日志，只做简单处理。 
     * @param joinPoint,可以取得被拦截方法的一些信息 
     */  
    public void logging(JoinPoint joinPoint) {  
        //得到被拦截方法参数，并打印  
        Object[] args = joinPoint.getArgs();  
        for (int i = 0; i < args.length; i++) {  
            System.out.println("method arg" + i + " -- " + args[i]);  
        }  
          
        //得到被拦截方法签名  
        System.out.println(joinPoint.getSignature().getName());  
          
        //记录系统日志具体实现  
        System.out.println(">>>>>>>>>>>>> ----logging-----");  
    }  
} 
