package com.tao.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//execution：用于匹配符合的方法；
//within：用于匹配指定的类及其子类中的所有方法。
//this：匹配可以向上转型为this指定的类型的代理对象中的所有方法。
//target：匹配可以向上转型为target指定的类型的目标对象中的所有方法。
//args(参数类型列表)：用于匹配运行时传入的参数列表的类型为指定的参数列表类型的方法；
//@annotation(注解类型)：用于匹配持有指定注解的方法；
//@within(注解类型)：用于匹配持有指定注解的类的所有方法；
//@target(注解类型)：用于匹配持有指定注解的目标对象的所有方法；
//@args(注解列表)：用于匹配运行时 传入的参数列表的类型持有 注解列表对应的注解 的方法；



// @Aspect表示这个类是一个切面类
@Aspect
// @Component注解保证这个切面类能够放入IOC容器
@Component
@Slf4j
public class LogAspect {

    // @Before注解：声明当前方法是前置通知方法
    // value属性：指定切入点表达式，由切入点表达式控制当前通知方法要作用在哪一个目标方法上
    @Before(value = "execution(public int com.tao.proxy.CalculatorPureImpl.add(..))")
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