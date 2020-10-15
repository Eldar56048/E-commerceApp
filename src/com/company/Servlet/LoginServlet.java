package com.company.Servlet;

import com.company.models.User;
import com.company.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = new UserRepository();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = null;
        try {
            user = userRepository.getUserByUsernameAndPassword(username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HttpSession httpSession = req.getSession();
        if(user==null){
            httpSession.setAttribute("MessageLogin","Invalid Username or Password");
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }
        else{
            httpSession.setAttribute("User",user);
            resp.sendRedirect(req.getContextPath()+"/user.jsp");
        }
    }
}
