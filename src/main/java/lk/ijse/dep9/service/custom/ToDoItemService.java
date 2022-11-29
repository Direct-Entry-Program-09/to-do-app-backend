package lk.ijse.dep9.service.custom;

import lk.ijse.dep9.dto.ToDoItemDTO;
import lk.ijse.dep9.service.SuperService;

import java.util.List;

public interface ToDoItemService extends SuperService {
    public void addNewToDoItem(ToDoItemDTO toDoItemDTO);
    public List<ToDoItemDTO> getToDoItems();
    public void updateToDoItem(ToDoItemDTO toDoItemDTO);
    public void deleteToDoItem(Integer id);
    public void deleteAll();

}
