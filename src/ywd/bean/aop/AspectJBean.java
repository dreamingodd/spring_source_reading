package ywd.bean.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJBean {
    // It will not be invoked.
    @Pointcut("execution(* *.test(..))")
    public void test() {
        System.out.println("what?");
    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @After("test()")
    public void afterTest(){
        System.out.println("afterTest");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p) {
        System.out.println("AroundBefore");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("AroundAfter");
        return o;
    }
}
