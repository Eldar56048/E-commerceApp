package com.company.Servlet;

import com.company.models.Product;
import com.company.repositories.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AboutProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductRepository productRepository = new ProductRepository();
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = null;
        try {
            product = productRepository.getProductByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("product",product);
        req.getRequestDispatcher("aboutProduct.jsp").forward(req,resp);
    }
}
