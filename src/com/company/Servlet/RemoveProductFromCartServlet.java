package com.company.Servlet;

import com.company.models.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        httpSession.setAttribute("ShoppingCart",items);
        resp.sendRedirect("cart.jsp");
    }
}
