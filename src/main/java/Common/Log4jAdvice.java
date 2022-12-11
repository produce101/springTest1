package Common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class Log4jAdvice {

    public void printLogging() {
        System.out.println("공통 로그4j 비즈니스 로직 수행전 동작");
    }

    public void printLogging2(JoinPoint joinPoint, Object returnOb) {
        Signature s = joinPoint.getSignature();

        Object[] args = joinPoint.getArgs();

        System.out.println("콩순이는 졸커야~~" + s);
        System.out.println("레이는 성격도 좋아~~" + args[0] + " " + args[1]);

        System.out.println("리컨값은 "  + returnOb);

        if(returnOb instanceof Integer) {
            System.out.println("형은 인테져??");
        } else if(returnOb instanceof String) {
            System.out.println("형은 문자열??");
        }
    }

    public void printLogging33(JoinPoint joinPoint, Object returnOb) {
        Signature s = joinPoint.getSignature();
        System.out.println("22레이는 성격도 좋아~~");

        System.out.println("22리컨값은 "  + returnOb);
    }

    public void printLogging3(ProceedingJoinPoint pjp) throws Throwable {


        pjp.proceed();
        Signature s = pjp.getSignature();
        System.out.println("정말유????" + s.getName() + "\n###" + s.toString() + "\n###" + s.toLongString() + "\n###" + s.toShortString());
        System.out.println("올라운드 되요??");
    }

    public void printLogging4(JoinPoint jp, Exception exceptObj) {
        System.out.println("예외 처리는 " + exceptObj.getMessage());

        if(exceptObj instanceof IllegalArgumentException) {
            System.out.println("1111");
        }

        if(exceptObj instanceof NumberFormatException) {
            System.out.println("2222");
        }
        if(exceptObj instanceof Exception) {
            System.out.println("3333");
        }

        if(exceptObj instanceof RuntimeException) {
            System.out.println("444");
        }

    }
}
