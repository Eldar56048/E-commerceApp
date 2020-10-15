package com.company.Servlet;

import com.company.models.Functions;
import com.company.models.Item;
import com.company.models.Product;
import com.company.repositories.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddProductCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Functions functions = new Functions();
        ProductRepository productRepository = new ProductRepository();
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

        httpSession.setAttribute("ShoppingCart",items);
        resp.sendRedirect("cart.jsp");
    }


}
