package auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller("customLogoutSuccess")
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {



        if(authentication != null && authentication.getDetails() != null) {
            try {
                System.out.println("로그아웃 로그아웃입니다~~~ " + authentication.getAuthorities());
                request.getSession().invalidate();
                System.out.println("로그아웃 되었습니당~");

                response.sendRedirect("/auth/customLogin");
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("/");

    }
}
