package com.company.repositories;

import com.company.models.Product;
import com.company.repositories.interfaces.IDBRepository;
import com.company.repositories.interfaces.IProductRepository;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.ServerErrorException;
import jakarta.ws.rs.core.Response;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ProductRepository implements IProductRepository {
    private IDBRepository dbrepo = new MySQLRepository();


    public ArrayList<Product> FillProduct() throws SQLException {
        String sql = "SELECT * FROM product  "  ;
        return query(sql);
    }

    @Override
    public void add(Product entity) throws SQLException {
        try {
            String sql = "INSERT INTO product(name, price, structure, category, photoUrl) " +
                    "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getName());
            stmt.setDouble(2, entity.getPrice());
            stmt.setString(3, entity.getStructure());
            stmt.setString(4, entity.getCategory());
            stmt.setString(5, entity.getPhotoUrl());
            stmt.execute();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    @Override
    public void update(Product entity) {
        String sql = "UPDATE  product SET name=?, price= ?, structure = ?, category = ? where id=?";
        try {
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1,entity.getName());
            stmt.setDouble(2,entity.getPrice());
            stmt.setString(3,entity.getCategory());
            stmt.setString(4,entity.getCategory());
            stmt.setInt(5, (int) entity.getId());
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Product entity) {
        try {
            String sql = "Delete from product WHERE id = ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setInt(1, (int) entity.getId());
            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public ArrayList<Product> query(String sql) throws SQLException {
        try {
            System.out.println("Hello");
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Product> products = new ArrayList<>();

            while (rs.next()) {
                Product product = new Product(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("structure"),
                        rs.getString("category"),
                        rs.getString("photoUrl")
                );

                products.add(product);
                System.out.println(rs.getString("name"));
            }
            return products;
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    @Override
    public Product queryOne(String sql) throws SQLException {
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return new Product(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("structure"),
                        rs.getString("category"),
                        rs.getString("photoUrl")
                );
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return null;
    }

    @Override
    public Product getProductByID(long id) throws SQLException {
        String sql = "SELECT * FROM product WHERE id = " + id ;
        return queryOne(sql);
    }



    @Override
    public TreeSet<String> getCategory() throws SQLException {
        String sql = "select DISTINCT(category) from product";
        TreeSet<String> categories = new TreeSet<>();
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                    categories.add(rs.getString("category"));
            }
            return categories;
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    @Override
    public ArrayList<Product> getProductsByNames(String name) throws SQLException {
        String sql = "SELECT * FROM product WHERE name LIKE '%"+name+"%'";
        return query(sql);
    }
}
