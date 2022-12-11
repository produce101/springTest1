package auth;


import org.eclipse.equinox.log.LogFilter;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;




public class SampleFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("~~~필터이닛입니다~~~~");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)servletRequest;

        String remoteAddr = req.getRemoteAddr();
        String uri = req.getRequestURI();
        String url = req.getRequestURL().toString();

        String queryString = req.getQueryString();

        String referer = req.getHeader("referer");
        String agent = req.getHeader("User-Agent");

        System.out.println("---START LOG FILTER---"); //filter 가 실행

        System.out.println("remoteAddr: "+remoteAddr+"\n"); // ip주소
        System.out.println("uri: "+uri+"\n");
        System.out.println("url: "+url+"\n");
        System.out.println("quertString: "+queryString+"\n");
        System.out.println("referer: "+referer+"\n"); // 이전 페이지(보내는 페이지) url
        System.out.println("agent: "+agent+"\n");	// 사용자 정보(browser,os등...)
        System.out.println("---END LOG FILTER---"); //filter 가 실행

        System.out.println("이게 두필터라는거구요~~~" + remoteAddr);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
