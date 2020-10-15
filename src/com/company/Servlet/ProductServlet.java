package com.company.Servlet;

import com.company.models.Product;
import com.company.repositories.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

public class ProductServlet extends HttpServlet {
    public static ArrayList<Product> getCategoryProducts(ArrayList<Product> products,String category){
        ArrayList<Product> categoryProducts = new ArrayList<>();
        for(Product product: products){
            if(product.getCategory().equals(category)){
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductRepository productRepository = new ProductRepository();
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
            req.setAttribute("products",getCategoryProducts(products,req.getParameter("Category")));
            req.setAttribute("Category",req.getParameter("Category")+" ");
        }

        else {
            req.setAttribute("products", products);
            req.setAttribute("Category","All ");
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchText = req.getParameter("SearchText");
        ProductRepository productRepository = new ProductRepository();
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
