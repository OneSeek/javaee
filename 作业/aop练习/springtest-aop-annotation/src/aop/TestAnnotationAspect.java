package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect  
public class TestAnnotationAspect {  
  
    @Pointcut("execution(* service.*.*(..))")  
    private void pointCutMethod() {  
    }  
  
    //����ǰ��֪ͨ  
    @Before("pointCutMethod()")  
    public void doBefore(JoinPoint jp) {  
        System.out.println("doBefore: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());  
    }  
  
    //��������֪ͨ  
    @AfterReturning(pointcut = "pointCutMethod()", returning = "result")  
    public void doAfterReturning(JoinPoint jp,String result) {  
        System.out.println("doAfterReturning:" + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName()+"result:"+result);  
    }  
  
    //��������֪ͨ  
    @AfterThrowing(pointcut = "pointCutMethod()", throwing = "ex")  
    public void doThrowing(JoinPoint jp, Throwable ex) {  
        System.out.print("doThowing: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName()+"  ");  
        System.out.println("error message:"+ex.getMessage());  
    }  
  
    //��������֪ͨ  
    @After("pointCutMethod()")  
    public void doAfter(JoinPoint jp) {  
        System.out.println("doAfter: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());  
    }  
  
    //��������֪ͨ  
    @Around("pointCutMethod()")  
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {  
        System.out.println("doAround-begin");
    	Object retVal = pjp.proceed();  
        System.out.println("doAround-end");
        return retVal;  
    }  
}  