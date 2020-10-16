package com.company.Servlet;

import com.company.models.Functions;
import com.company.models.Item;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

public class ReduceQuantityServlet extends HttpServlet {
    Functions functions = new Functions();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        HttpSession httpSession = req.getSession();
        ArrayList<Item> items = (ArrayList<Item>) httpSession.getAttribute("ShoppingCart");
        for(Item item : items){
            if(item.getProduct().getId()==id)
                if(item.getQuantity()>0) {
                    item.setQuantity(item.getQuantity() - 1);
                }
        }
        Cookie cookie = functions.getCookieByName(req.getCookies(),"CartSize");
        Integer size = items.size();
        cookie = new Cookie("CartSize",size.toString());
        resp.addCookie(cookie);
        httpSession.setAttribute("ShoppingCart",items);
        httpSession.setMaxInactiveInterval(60);
        resp.sendRedirect("cart.jsp");
    }
}
