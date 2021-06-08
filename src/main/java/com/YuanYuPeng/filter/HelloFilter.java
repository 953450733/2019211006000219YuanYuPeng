package com.YuanYuPeng.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter",
urlPatterns = {"/hello"}
)

//task 1:url /hello -filter is only for one servlet -HelloServlet
//task 2:url /*-this filter of for all servlet
//task 3:3 url - this filter for these 3 url only
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in HelloFilter-->init()");  //when called?

    }

    public void destroy() {
        System.out.println("i am in HelloFilter-->destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in HelloFilter-->doFilter()-before servlet-(request come here)");

        chain.doFilter(request, response);
        System.out.println("i am in HelloFilter-->doFilter()-after servlet-(response come here)");

    }
}
