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

public class RemoveWishList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        HttpSession httpSession = req.getSession();
        ArrayList<Product> wishList = (ArrayList<Product>) httpSession.getAttribute("WishList");
        for(int i=0;i<wishList.size();i++){
            if(wishList.get(i).getId()==id){
                wishList.remove(i);
            }
        }
        Integer size = wishList.size();
        Cookie cookie = new Cookie("WishListSize",size.toString());
        cookie.setMaxAge(5*60);
        resp.addCookie(cookie);
        httpSession.setAttribute("WishList",wishList);
        resp.sendRedirect("wishList.jsp");
    }
}
