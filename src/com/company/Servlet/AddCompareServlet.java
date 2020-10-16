package com.company.Servlet;

import com.company.models.Functions;
import com.company.models.Product;
import com.company.repositories.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AddCompareServlet extends HttpServlet {
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
        Map<Integer,Product> compareMap = null;
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("CompareMapList")!=null) {
            compareMap = (Map<Integer,Product>) httpSession.getAttribute("CompareMapList");
        }
        else{
            compareMap = new LinkedHashMap<>();
        }
        if (functions.isProductInMap(compareMap, (int) id)==false) {
            compareMap.put((int) id,product);
        }
        Integer size = compareMap.size();
        Cookie cookie = new Cookie("CompareMapSize",size.toString());
        cookie.setMaxAge(5*60);
        resp.addCookie(cookie);
        httpSession.setAttribute("CompareMapList",compareMap);
        httpSession.setMaxInactiveInterval(60);
        resp.sendRedirect("compare.jsp");
    }
}
