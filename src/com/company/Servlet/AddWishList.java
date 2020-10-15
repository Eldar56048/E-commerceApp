package com.company.Servlet;

import com.company.models.Functions;
import com.company.models.Item;
import com.company.models.Product;
import com.company.repositories.ProductRepository;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;


public class AddWishList extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductRepository productRepository = new ProductRepository();
        Functions functions = new Functions();
        Product product = null;
        long id= Integer.parseInt(req.getParameter("id"));
        try {
            product = productRepository.getProductByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Queue<Product> wishList = null;
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("WishList")!=null) {
            wishList = (Queue<Product>) httpSession.getAttribute("WishList");
        }
        else{
            wishList = new LinkedList<>();
        }
        if (functions.isWishInCart(wishList, product)==false) {
            wishList.add(product);
        }
        Integer size = wishList.size();
        Cookie cookie = new Cookie("WishListSize",size.toString());
        cookie.setMaxAge(5*60);
        resp.addCookie(cookie);
        httpSession.setAttribute("WishList",wishList);
        resp.sendRedirect("wishList.jsp");
    }
}
