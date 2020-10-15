package com.company.repositories.interfaces;

import com.company.models.User;

import java.sql.SQLException;

public interface IUserRepository extends IEntityRepository<User>{
    User getUserByUsernameAndPassword(String username,String password) throws SQLException;
}
