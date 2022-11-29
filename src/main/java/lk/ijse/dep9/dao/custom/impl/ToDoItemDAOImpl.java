package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.ToDoItemDAO;
import lk.ijse.dep9.entity.ToDoItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ToDoItemDAOImpl implements ToDoItemDAO {
    private Connection connection;

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
    public void delete(Integer id){
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM todo_item WHERE id=?");
            statement.setInt(1,id);
            if(statement.executeUpdate()!=1) throw new RuntimeException("Failed to delete item");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void deleteAll(){
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM todo_item");
        if (statement.executeUpdate()!=1) throw new RuntimeException("Failed to delete all the items");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
