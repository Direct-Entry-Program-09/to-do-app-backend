package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.UserDAO;
import lk.ijse.dep9.dao.custom.exception.ConstraintViolationException;
import lk.ijse.dep9.entity.SuperEntity;
import lk.ijse.dep9.entity.User;

import java.io.Serializable;
import java.sql.*;
import java.util.List;
import java.util.Optional;


public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String username) throws ConstraintViolationException {
        try {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM `user` WHERE username=?");
            stm.setString(1,username);
            stm.executeUpdate();

        } catch (SQLException e) {
            if (existsById(username)) throw new ConstraintViolationException("The username cannot be deleted as it is engage in other relations");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(String username) {
        try {
            PreparedStatement stmExists = connection.prepareStatement("SELECT * FROM `user` WHERE username=?");
            stmExists.setString(1,username);
            ResultSet resultSet = stmExists.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(String username) {
        try {
            PreparedStatement stmGet = connection.prepareStatement("SELECT * FROM `user` WHERE username=?");
            stmGet.setString(1,username);
            ResultSet rst = stmGet.executeQuery();
            if (rst.next()){
                String password = rst.getString("password");
                String fullName = rst.getString("fullName");
                System.out.println("dao"+username);
                System.out.println("dao"+password);
                System.out.println("dao"+fullName);
                return Optional.of(new User(username,password,fullName));
            }else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object save(User user) throws ConstraintViolationException {
        try {
            PreparedStatement stmCreate = connection.prepareStatement("INSERT INTO `user` (username, password, fullName) VALUES (?,?,?)");
            stmCreate.setString(1,user.getUsername());
            stmCreate.setString(2,user.getPassword());
            stmCreate.setString(3,user.getFullName());
            int executedNo = stmCreate.executeUpdate();
            if (executedNo==1){
                return user;
            }else {
                throw new SQLException("Failed to create the user");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object update(User entity) throws ConstraintViolationException {
        return null;
    }


}
