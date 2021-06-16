package com.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/validation.jsp","/lab2/welcome.jsp"})
public class LoginFilter implements Filter {
    public void destroy() {
        System.out.println("i am in LoginFilter--destroy()");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoginFilter--doFilter()-- request before chain()");
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        System.out.println(req.getSession(false));
        if(req.getSession(false).isNew()) {
            RequestDispatcher dispatcher=request.getRequestDispatcher("welcome.jsp");
            dispatcher.forward(req,res);
        }
        else {
            res.sendRedirect("login.jsp");
        }
        chain.doFilter(request,response);
        System.out.println("i am in LoginFilter--doFilter()-- response after chain()");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in LoginFilter--init()");
    }

}