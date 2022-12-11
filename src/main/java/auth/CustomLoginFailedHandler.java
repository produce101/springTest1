package auth;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;

import javax.management.BadAttributeValueExpException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller("customLoginFailed")
public class CustomLoginFailedHandler implements AuthenticationFailureHandler {
/*    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        List<String> roleNames = new ArrayList<>();

        authentication.getAuthorities().forEach(authority -> {
            roleNames.add(authority.getAuthority());
        });

        System.out.println("로그인 석세스입니다~~~ " + authentication.getAuthorities());


        if(roleNames.contains("ROLE_ADMIN")) {

            response.sendRedirect("/auth/admin");
            return;
        }

        if(roleNames.contains("ROLE_MEMBER1")) {

            response.sendRedirect("/auth/member");
            return;
        }

        response.sendRedirect("/");
    }*/

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException{



        String exceptionMessage = exception.getMessage();

        if(exception instanceof UsernameNotFoundException) {
            System.out.println("유저네임파인드 엑셉션입니다~~");


        }

        if(exception instanceof BadCredentialsException) {
            BadCredentialsException a = (BadCredentialsException) exception;
            System.out.println("유저네임파인드 엑셉션입니다~~2222" + a.getLocalizedMessage());
            exceptionMessage = "notAuth";
        }



        System.out.println("페일드 페일드입니다~~ " + exception.getMessage());



        /*MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        MediaType jsonMimeType = MediaType.APPLICATION_JSON;*/

        /*if(exceptionMessage.equals("Bad credentials")) {

        }*/


        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(exceptionMessage);

    }
}
