package Common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

@Service
@Aspect



public class LogAdvice2 {

    @Pointcut("execution(* Board..*Test1.a*(..))")
    public void getPointcut() {}

    @Before("PointCommon.getPointcut()")
    public void printLog() {
        System.out.println("어노테이션 비포로하는 프린트 로그~ 어쩔~~~");
    }


    @After("PointCommon.getPointcut()")
    public void printLog2(JoinPoint joinPoint) {
        System.out.println("애프터터터~~~~" + " " + joinPoint.getSignature());
    }

    @AfterReturning(value = "PointCommon.getPointcut()", returning = "test3")
    public void printLog3( JoinPoint joinPoint, Object test3) {


        System.out.println("애프터터터~~~~ddd" + test3.toString() + " " + joinPoint.getSignature() + " " + test3);
    }


    @AfterThrowing(value = "PointCommon.getPointcut()", throwing = "exeObj")
    public void printLog4( JoinPoint joinPoint, Exception exeObj) {
        System.out.println("???????????" + exeObj.getMessage() + " " +  joinPoint.getSignature());
    }



    @Around("PointCommon.getPointcut()")
    public Object printLog5(ProceedingJoinPoint proceedingJoinPoint)  {

        System.out.println("전전전전전전전전전전");
        //proceedingJoinPoint.proceed();

        System.out.println("후후후후후후후후후후");
        return "뭐야 이거허허참나";
    }


}
