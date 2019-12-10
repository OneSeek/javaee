package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import util.Log;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class TestAnnotationAspect {  
  
    @Pointcut("execution(* service.*.*(..))")
    private void pointCutMethod() {  
    }  
  

    //��������֪ͨ
    @AfterReturning(pointcut = "pointCutMethod()", returning = "result")
    public void doAfterReturning(JoinPoint jp, String result) {
        System.out.println("doAfterReturning:" + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName()+"result:"+result);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ

        Log.writeLog("ʱ�䣺"+df.format(new Date())+",��¼�û�����"+ jp.getArgs()[0]+",���룺"+jp.getArgs()[1]+",��¼"+result);

    }
}  