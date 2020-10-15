package com.company.repositories.interfaces;

import com.company.models.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

public interface IProductRepository extends IEntityRepository<Product>{
    Product getProductByID(long id) throws SQLException;
    ArrayList<Product> getProductsByNames(String name) throws SQLException;
    TreeSet<String> getCategory() throws SQLException;
}
