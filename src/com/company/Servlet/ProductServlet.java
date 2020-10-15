package com.company.Servlet;

import com.company.models.Functions;
import com.company.models.Product;
import com.company.models.ProductPriceComparator;
import com.company.repositories.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class ProductServlet extends HttpServlet {
    ProductPriceComparator priceComparator = new ProductPriceComparator();
    Functions functions = new Functions();
    ProductRepository productRepository = new ProductRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> products = null;
            try {
                products = productRepository.FillProduct();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        TreeSet<String> categories = null;
            try {
                categories = productRepository.getCategory();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        req.setAttribute("Categories",categories);

        if(req.getParameter("Category")!=null){
            ArrayList<Product> categoryProducts =functions.getCategoryProducts(products,req.getParameter("Category"));
            Collections.sort(categoryProducts,priceComparator);
            req.setAttribute("products",categoryProducts);
            req.setAttribute("Category",req.getParameter("Category")+" ");
        }

        else {
            Collections.sort(products,priceComparator);
            req.setAttribute("products", products);
            req.setAttribute("Category","All ");
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchText = req.getParameter("SearchText");
        ArrayList<Product> products = null;
        TreeSet<String> categories = null;
        try {
             products = productRepository.getProductsByNames(searchText);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            categories = productRepository.getCategory();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("Categories",categories);
        req.setAttribute("products",products);
        req.setAttribute("Category",searchText+" Names ");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
