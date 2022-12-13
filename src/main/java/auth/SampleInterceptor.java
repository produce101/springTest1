package auth;


import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.logging.Handler;

/*@Controller("sampleInterceptor")
public class SampleInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("프레핸들러입니당~~");
        return true;
    }
}*/


@Controller("sampleInterceptor")
public class SampleInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        request.getSession(true);

        System.out.println("프레핸들러입니당~~" + request);
        System.out.println("핸들러는~~" + handler);

        HandlerMethod method = (HandlerMethod) handler;

        Method methodMethod = method.getMethod();


        System.out.println("빈은~~" + method.getBean());

        System.out.println("메서드는~~" + methodMethod.getName());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("포스트핸들" + modelAndView.getModel().get("abc"));

        request.getSession().setAttribute("abcc",modelAndView.getModel().get("abc"));

        //response.sendRedirect("/dod");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("애프터컴플레이션~~임당~\n\n\n");
    }
}