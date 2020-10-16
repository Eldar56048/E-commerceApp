package com.company.Servlet;

import com.company.models.Product;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

public class RemoveCompareServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession httpSession = req.getSession();
        Map<Integer,Product> compareMap = (Map<Integer, Product>) httpSession.getAttribute("CompareMapList");
        compareMap.remove(id);
        Integer size = compareMap.size();
        Cookie cookie = new Cookie("CompareMapSize",size.toString());
        cookie.setMaxAge(5*60);
        resp.addCookie(cookie);
        httpSession.setAttribute("CompareMapList",compareMap);
        httpSession.setMaxInactiveInterval(60);
        resp.sendRedirect("compare.jsp");
    }
}
