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
import java.util.Queue;

public class AddProductCartServlet extends HttpServlet {

    ProductRepository productRepository = null;
    @Override
    public void init() throws ServletException {
        productRepository = new ProductRepository();
    }
    Functions functions = new Functions();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Functions functions = new Functions();
        Product product = null;
        long id= Integer.parseInt(req.getParameter("id"));
        try {
            product = productRepository.getProductByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ArrayList<Item> items = null;
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("ShoppingCart")!=null) {
            items = (ArrayList<Item>) httpSession.getAttribute("ShoppingCart");
        }
        else{
            items = new ArrayList<>();
        }
        if (functions.isItemInCart(items, product)==false) {
            items.add(new Item(product, 1));
        }
        Integer size = items.size();
        Cookie cookie = new Cookie("CartSize",size.toString());
        cookie.setMaxAge(5*60);
        resp.addCookie(cookie);
        httpSession.setAttribute("ShoppingCart",items);
        httpSession.setMaxInactiveInterval(60);
        resp.sendRedirect("Product");
    }


}
