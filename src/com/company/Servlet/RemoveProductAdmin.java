package com.company.Servlet;

import com.company.models.Product;
import com.company.repositories.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class RemoveProductAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductRepository productRepository = new ProductRepository();
        int id = Integer.parseInt(req.getParameter("id"));
        String path = "C:/Users/DELL/IdeaProjects/E-commerce App/web/";
        Product product = null;
        try {
            product = productRepository.getProductByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            File file = new File(path+product.getPhotoUrl());
            resp.setContentType("text/html");
            String fileName = file.getName();
            if (file.delete()) {
                System.out.println("Deleted the folder: " + file.getName());
                path = path.replace("/", "%2F");
                path = path.replace(fileName, "");
            } else {
                try {
                    throw new Exception("Failed to delete the folder.");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        catch (Exception e){
            throw e;
        }
        productRepository.remove(product);
        resp.sendRedirect("Product");
    }
}
