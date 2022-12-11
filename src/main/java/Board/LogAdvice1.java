package Board;


import lombok.extern.log4j.Log4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice1 {

    @Before( "execution(* Common.*.*(..))")
    public void lo1() {
        System.out.println("마 이게 관심사 로직이담마~");
    }

}
