package com.company.Servlet;

import com.company.models.Item;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

public class RemoveProductFromCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        HttpSession httpSession = req.getSession();
        ArrayList<Item> items = (ArrayList<Item>) httpSession.getAttribute("ShoppingCart");
        for(int i=0;i<items.size();i++){
            if(items.get(i).getProduct().getId()==id){
                items.remove(i);
            }
        }
        Integer size = items.size();
        Cookie cookie = new Cookie("CartSize",size.toString());
        cookie.setMaxAge(5*60);
        resp.addCookie(cookie);
        httpSession.setAttribute("ShoppingCart",items);
        httpSession.setMaxInactiveInterval(60);
        resp.sendRedirect("cart.jsp");
    }
}
