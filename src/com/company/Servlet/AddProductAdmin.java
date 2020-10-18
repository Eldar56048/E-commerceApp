package com.company.Servlet;

import com.company.models.Product;
import com.company.repositories.ProductRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

@MultipartConfig
public class AddProductAdmin extends HttpServlet {

    ProductRepository productRepository = null;
    @Override
    public void init() throws ServletException {
        productRepository = new ProductRepository();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        double productPrice = Integer.parseInt(req.getParameter("productPrice"));
        String productStructure = req.getParameter("productStructure");
        String productCategory = req.getParameter("productCategory");

        resp.setContentType("text/plain;charset=UTF-8");
        ServletOutputStream os = resp.getOutputStream();
        ServletConfig sc = getServletConfig();
        String path = "C:/Users/DELL/IdeaProjects/E-commerce App/web/img";
        System.out.println(productName);
        Part filePart = req.getPart("productFile");
        String fileName = filePart.getSubmittedFileName();
        InputStream is = filePart.getInputStream();
        Files.copy(is, Paths.get(path +"/"+fileName),
                StandardCopyOption.REPLACE_EXISTING);
        System.out.println(path+fileName);
        System.out.println("File successfully added");
        os.print("File successfully uploaded");
        Product product = new Product(productName,productPrice,productStructure,productCategory,"img/"+fileName);
        try {
            productRepository.add(product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("Product");
    }
}
