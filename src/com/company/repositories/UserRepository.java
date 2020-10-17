package com.company.repositories;

import com.company.models.User;
import com.company.repositories.interfaces.IDBRepository;
import com.company.repositories.interfaces.IUserRepository;
import jakarta.ws.rs.BadRequestException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private IDBRepository dbrepo = new MySQLRepository();

    @Override
    public void add(User entity) {
        try {
            String sql = "INSERT INTO users(name, surname, username, password, birthday, role) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getName());
            stmt.setString(2, entity.getSurname());
            stmt.setString(3, entity.getUsername());
            stmt.setString(4, entity.getPassword());
            stmt.setDate(5, new java.sql.Date(entity.getBirthday().getTime()));
            stmt.setString(6, entity.getRole());
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(User entity) {
        String sql = "UPDATE users " +
                "SET ";
        int c = 0;
        if (entity.getName() != null) {
            sql += "name=?, "; c++;
        }
        if (entity.getSurname() != null) {
            sql += "surname=?, "; c++;
        }
        if (entity.getPassword() != null) {
            sql += "password=?, "; c++;
        }
        if (entity.getBirthday() != null) {
            sql += "birthday=?, "; c++;
        }

        sql = sql.substring(0, sql.length() - 2);

        sql += " WHERE username = ?";

        try {
            int i = 1;
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            if (entity.getName() != null) {
                stmt.setString(i++, entity.getName());
            }
            if (entity.getSurname() != null) {
                stmt.setString(i++, entity.getSurname());
            }
            if (entity.getPassword() != null) {
                stmt.setString(i++, entity.getPassword());
            }
            if (entity.getBirthday() != null) {
                stmt.setDate(i++, (Date) entity.getBirthday());
            }
            stmt.setString(i++, entity.getUsername());

            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public void remove(User entity) {
        try {
            String sql = "Delete from users WHERE id = ?";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
    }

    @Override
    public List<User> query(String sql) {
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            LinkedList<User> users = new LinkedList<>();
            while (rs.next()) {
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        rs.getDate("birthday"),
                        rs.getString("role")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public User queryOne(String sql)  { // ОРМ ????
        try {
            Statement stmt = dbrepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        rs.getDate("birthday"),
                        rs.getString("role")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public User getUserByID(long id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = " + id ;
        return queryOne(sql);
    }
    @Override
    public User getUserByUsernameAndPassword(String username,String password) {
        String sql = "SElECT * FROM users WHERE username = '"+username+"' AND password = '"+password+"'";
        return queryOne(sql);
    }

    public User getUserByUsername(String username){
            String sql = "SELECT * FROM users WHERE username = '"+username+"'";
            return queryOne(sql);
    }
}
