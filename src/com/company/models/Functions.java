package com.company.models;

import javax.servlet.http.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;

public class Functions {
    public int countSizeCart(ArrayList<Item> items){
        int size =0;
        for (Item item:items){
            size+=item.getQuantity();
        }
        return size;
    }

    public int countWishCartSize(ArrayList<Product> wishList){
        return wishList.size();
    }

    public boolean isWishInCart(Queue<Product> products, Product product){
        for(Product product1 : products) {
            if(product1.getId()==product.getId())return true;
        }
        return false;
    }

    public boolean isItemInCart(ArrayList<Item> items, Product product){
        for(Item item : items) {
            if(item.getProduct().getId()==product.getId())return true;
        }
        return false;
    }

    public ArrayList<Product> getCategoryProducts(ArrayList<Product> products,String category){
        ArrayList<Product> categoryProducts = new ArrayList<>();
        for(Product product: products){
            if(product.getCategory().equals(category)){
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }

    public Cookie getCookieByName(Cookie[] cookies, String name){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(name))return cookie;
        }
        return null;
    }

    public boolean isProductInMap(Map<Integer,Product> productMap,int id){
        if(productMap.get(id)!=null){
            return true;
        }
        return false;
    }

    public String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

    public void count(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;
        for(Cookie cookie1 : cookies){
            if(cookie1.getName().equals("counter"))cookie = cookie1;
        }
        if(cookie == null){
            cookie = new Cookie("counter","0");
        }
        int count = Integer.parseInt(cookie.getValue())+1;
        cookie.setValue(String.valueOf(count));
        cookie.setMaxAge(5*60);
        resp.addCookie(cookie);
    }


}
