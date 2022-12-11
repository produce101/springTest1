package auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller("customLoginSuccess")
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        List<String> roleNames = new ArrayList<>();


        Object a = authentication.getPrincipal();


        CustomUser customUser = (CustomUser) authentication.getPrincipal();


        String info = customUser.getMemberVO().getInfo();


        if(info.equals("admin")) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("admin");
            return;
        }

        System.out.println("겟프린시팔은 " + a);
        System.out.println("겟프린시팔은2 " + a.getClass());
        System.out.println("겟프린시팔은3 " + info);

        authentication.getAuthorities().forEach(authority -> {
            roleNames.add(authority.getAuthority());
        });

        authentication.getDetails();

        System.out.println("로그인 석세스입니다~~~ " + authentication.getAuthorities());

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print("success");

        if(roleNames.contains("ROLE_ADMIN")) {

            //response.sendRedirect("/auth/admin");
            return;
        }

        if(roleNames.contains("ROLE_MEMBER1")) {

            //response.sendRedirect("/auth/member");
            return;
        }

        //response.sendRedirect("/");
    }

}
