package com.company.Servlet;

import com.company.models.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class AddQuantityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        HttpSession httpSession = req.getSession();
        ArrayList<Item> items = (ArrayList<Item>) httpSession.getAttribute("ShoppingCart");
        for(Item item : items){
            if(item.getProduct().getId()==id)
                item.setQuantity(item.getQuantity()+1);
        }
        httpSession.setAttribute("ShoppingCart",items);
        resp.sendRedirect("cart.jsp");
    }
}
