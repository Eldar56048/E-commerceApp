package com.company.repositories.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IEntityRepository<T> {
    void add(T entity) throws SQLException;
    void update(T entity);
    void remove(T entity);
    List<T> query(String sql) throws SQLException;
    T queryOne(String sql) throws SQLException;
}
