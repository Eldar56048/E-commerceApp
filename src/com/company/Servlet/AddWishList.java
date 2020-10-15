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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;


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
        ArrayList<Product> products = null;
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("WishList")!=null) {
            products = (ArrayList<Product>) httpSession.getAttribute("WishList");
        }
        else{
            products = new ArrayList<>();
        }
        if (functions.isWishInCart(products, product)==false) {
            products.add(product);
        }

        httpSession.setAttribute("WishList",products);
        resp.sendRedirect("wishList.jsp");
    }
}
