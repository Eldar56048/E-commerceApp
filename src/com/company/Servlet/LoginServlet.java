package com.company.Servlet;

import com.company.models.User;
import com.company.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = new UserRepository();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userRepository.getUserByUsernameAndPassword(username,password);
        HttpSession httpSession = req.getSession();
        if(user==null){
            Cookie cookie = new Cookie("MessageLogin","Error");
            cookie.setMaxAge(60);
            resp.addCookie(cookie);
            resp.sendRedirect("login.jsp");
        }

        else{
            httpSession.setAttribute("User",user);
            resp.sendRedirect("Product");
        }
    }
}
