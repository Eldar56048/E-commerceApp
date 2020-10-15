package com.company.repositories;


import com.company.repositories.interfaces.IDBRepository;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.ServerErrorException;
import jakarta.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLRepository implements IDBRepository {
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connStr = "jdbc:mysql://localhost/e_commerce_app?serverTimezone=Europe/Moscow&useSSL=false";
            return DriverManager.getConnection(connStr, "Eldar", "Eldar56048");
        } catch (SQLException | ClassNotFoundException ex) {
            throw new SQLException(ex);
        }
    }

}
