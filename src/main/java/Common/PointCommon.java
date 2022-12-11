package Common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCommon {

    @Pointcut("execution(* Board..*Test1.a*(..))")
    public void getPointcut() {}

}
