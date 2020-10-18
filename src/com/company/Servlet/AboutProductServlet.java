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

    ProductRepository productRepository = null;
    @Override
    public void init() throws ServletException {
        productRepository = new ProductRepository();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));//there i get the id
        Product product = null;
        try {
            product = productRepository.getProductByID(id);//there i fill the product from db
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("product",product);//there i set the attribute
        req.getRequestDispatcher("aboutProduct.jsp").forward(req,resp);
    }
}
