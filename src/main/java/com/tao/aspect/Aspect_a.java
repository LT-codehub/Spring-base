package com.tao.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Aspect_a
 * @Description:
 * @Author: LTMAX
 * @Date: 2022/8/722:09
 * @Version:
 */

@Slf4j
@Component
@Aspect
public class Aspect_a {
    // @Before注解：声明当前方法是前置通知方法
    // value属性：指定切入点表达式，由切入点表达式控制当前通知方法要作用在哪一个目标方法上
    @Before(value = "execution(* com.tao.proxy.*.*(..))")
    public void printLogBeforeCore() {
        log.debug("[AOP前置通知] 方法开始了");
    }

    @AfterReturning(value = "execution(public int com.tao.proxy.CalculatorPureImpl.add(int,int))")
    public void printLogAfterSuccess() {
        log.debug("[AOP返回通知] 方法成功返回了");
    }

    @AfterThrowing(value = "execution(public int com.tao.proxy.CalculatorPureImpl.add(int,int))")
    public void printLogAfterException() {
        log.debug("[AOP异常通知] 方法抛异常了");
    }

    @After(value = "execution(public int com.tao.proxy.CalculatorPureImpl.add(int,int))")
    public void printLogFinallyEnd() {
        log.debug("[AOP后置通知] 方法最终结束了");
    }

}
