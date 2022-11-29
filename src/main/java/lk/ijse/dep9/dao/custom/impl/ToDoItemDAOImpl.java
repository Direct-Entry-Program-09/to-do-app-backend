package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.ToDoItemDAO;
import lk.ijse.dep9.dao.util.status;
import lk.ijse.dep9.entity.ToDoItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ToDoItemDAOImpl implements ToDoItemDAO {
    private Connection connection;
    public ToDoItemDAOImpl(Connection connection){  // cause connection should be injected by the person who uses the DAO
        this.connection=connection;
    }


    @Override
    public ToDoItem save(ToDoItem toDoItem){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO todo_item(username,description,status) VALUES (?,?,?)");
            statement.setString(1,toDoItem.getUsername());
            statement.setString(2,toDoItem.getDescription());
            statement.setString(3,toDoItem.getStatus().toString());
            if (statement.executeUpdate()==1){
                return toDoItem;
            }else {
                throw new SQLException("Failed to create a to do item");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public ToDoItem update(ToDoItem toDoItem){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE todo_item SET username=?,description=?,status=? WHERE id=?");
            statement.setString(1,toDoItem.getUsername());
            statement.setString(2,toDoItem.getDescription());
            statement.setString(3,toDoItem.getStatus().toString());
            if (statement.executeUpdate()==1){
                return toDoItem;
            }else {
                throw new RuntimeException("Failed to update the item");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public long count() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(id) FROM `todo_item`");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id){
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM `todo_item` WHERE id=?");
            statement.setInt(1,id);
            if(statement.executeUpdate()!=1) throw new RuntimeException("Failed to delete item");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean existsById(Integer pk) {
        return false;
    }

    @Override
    public List<ToDoItem> findAll() {
        try {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM user");
            List<ToDoItem> toDoItemList=new ArrayList<>();
            while (rst.next()){
                int id = rst.getInt("id");
                String username = rst.getString("username");
                String description = rst.getString("description");
                String status1 = rst.getString("status");

                toDoItemList.add(new ToDoItem(id,username,description, status.valueOf(status1)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Optional<ToDoItem> findById(Integer pk) {
        return Optional.empty();
    }

    @Override
    public void deleteAll(){
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM `todo_item` WHERE true");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
