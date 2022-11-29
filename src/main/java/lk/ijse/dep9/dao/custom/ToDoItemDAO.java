package lk.ijse.dep9.dao.custom;

import lk.ijse.dep9.dao.CrudDAO;
import lk.ijse.dep9.entity.ToDoItem;

import java.util.List;

public interface ToDoItemDAO extends CrudDAO<ToDoItem,Integer> {
    void deleteAll();

}
