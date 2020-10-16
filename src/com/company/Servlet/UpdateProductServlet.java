package com.company.Servlet;

import com.company.models.Product;
import com.company.repositories.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class UpdateProductServlet extends HttpServlet {
    ProductRepository productRepository = new ProductRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = null;
        try {
            product = productRepository.getProductByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("product",product);
        req.getRequestDispatcher("updateProduct.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        String productName = req.getParameter("productName");
        double productPrice = Double.parseDouble(req.getParameter("productPrice"));
        String productStructure = req.getParameter("productStructure");
        String productCategory = req.getParameter("productCategory");
        productRepository.update(new Product(id,productName,productPrice,productStructure,productCategory));
        resp.sendRedirect("Product");
    }
}
