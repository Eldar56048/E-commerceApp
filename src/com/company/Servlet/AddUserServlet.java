package com.company.Servlet;

import com.company.models.User;
import com.company.repositories.ProductRepository;
import com.company.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddUserServlet extends HttpServlet {
    UserRepository userRepository = null;

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepository();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String birthDay = req.getParameter("birthday");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(userRepository.getUserByUsername(username)!=null){
            httpSession.setAttribute("MessageAddUser","This Username is busy");
            httpSession.setMaxInactiveInterval(60);
            resp.sendRedirect("register.jsp");
        }
        else{
            userRepository.add(new User(name,surname,username,password,date,"user"));
            httpSession.setAttribute("MessageAddUser","Successfully registered");
            httpSession.setMaxInactiveInterval(60);
            resp.sendRedirect("login.jsp");
        }
    }
}
