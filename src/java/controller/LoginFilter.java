package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {
    
    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();
        Object user = (Object) req.getSession().getAttribute("valid_user");
        try {

            if (user == null) {

                if (url.contains("/secret")) {
                    res.sendRedirect(req.getContextPath() + "/login.xhtml");
                } else {
                    chain.doFilter(request, response);
                }

            } else {
                if (url.contains("/login.xhtml")) {

                    res.sendRedirect(req.getContextPath() + "/faces/secret/secret.xhtml");
                } else if (url.contains("/logout.xhtml")) {
                    req.getSession().invalidate();
                    res.sendRedirect(req.getContextPath() + "/login.xhtml");
                } else {
                    chain.doFilter(request, response);
                }
            }
        } catch (IOException | ServletException e) {
            System.out.println(e.getMessage());
        }
    }
    

}
