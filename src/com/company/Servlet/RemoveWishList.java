package com.company.Servlet;

import com.company.models.Functions;
import com.company.models.Item;
import com.company.models.Product;
import com.company.repositories.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class RemoveWishList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        HttpSession httpSession = req.getSession();
        Queue<Product> wishList = (Queue<Product>) httpSession.getAttribute("WishList");
        Iterator<Product> productIterator = wishList.iterator();
        while(productIterator.hasNext()){
            Product product = productIterator.next();
            if(product.getId()==id)productIterator.remove();
        }
        Integer size = wishList.size();
        Cookie cookie = new Cookie("WishListSize",size.toString());
        cookie.setMaxAge(5*60);
        resp.addCookie(cookie);
        httpSession.setAttribute("WishList",wishList);
        resp.sendRedirect("wishList.jsp");
    }
}
