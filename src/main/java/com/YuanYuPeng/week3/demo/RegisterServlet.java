package com.YuanYuPeng.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// automatic - new --> servlet


@WebServlet(
    urlPatterns = {"/register"},loadOnStartup = 1)

public class RegisterServlet extends HttpServlet {
    Connection con=null;  //class variable
    @Override
    public void init() throws ServletException {
        super.init();
       /* ServletContext context=getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);

            System.out.println(" con --> init()--> " + con);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        con=(Connection) getServletContext().getAttribute("con");
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// request come here- <from method=post>
        //get parameter from request
        PrintWriter writer = response.getWriter();
        String id=request.getParameter("id");
        String username=request.getParameter("username");//name of input type -<input type="text" name="username">
        String password=request.getParameter("password");//<input type="text" name="password">
        String email=request.getParameter("email");//<input type="text" name="Email">
        String gender=request.getParameter("gender");//<input type="radio" name="gender">
        String birthdate=request.getParameter("birthdate");//<input type="text name" name="birthdate" >

        String sql1="insert into Usertable values(?,?,?,?,?)";
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement(sql1);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,email);
            pstmt.setString(4,gender);
            pstmt.setString(5,birthdate);
            pstmt.executeUpdate();
            response.sendRedirect("login.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

           /* sql="select id,username.password,email,gender,birthdate from usertable";
            ResultSet rs=st.executeQuery(sql);
            PrintWriter out=response.getWriter();
            /*out.println("<html><title></title><body><table border=1><tr>");
            out.println("<td>Username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthdate</td></tr>");
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td>"+rs.getString("password")+"</td>");
                out.println("<td>"+rs.getString("email")+"</td>");
                out.println("<td>"+rs.getString("gender")+"</td>");
                out.println("<td>"+rs.getString("birthdate")+"</td>");

                out.println("</tr>");
            }
            out.println("</table></body></html>");
            request.setAttribute("name",rs); //name - string , value - any type (object)
            request.getRequestDispatcher("userList.jsp").forward(request,response);
            //after this point request given to userList.jsp
            //no more here
            System.out.println("i am in RegisterServlet-- doPost()--> after forward()");//not see this line
            */



    }


    }


