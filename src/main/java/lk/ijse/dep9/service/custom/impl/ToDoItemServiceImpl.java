package lk.ijse.dep9.service.custom.impl;

import lk.ijse.dep9.dao.DAOFactory;
import lk.ijse.dep9.dao.DAOTypes;
import lk.ijse.dep9.dao.SuperDAO;
import lk.ijse.dep9.dao.custom.ToDoItemDAO;
import lk.ijse.dep9.dao.custom.UserDAO;
import lk.ijse.dep9.dao.custom.impl.ToDoItemDAOImpl;
import lk.ijse.dep9.dto.ToDoItemDTO;
import lk.ijse.dep9.entity.ToDoItem;
import lk.ijse.dep9.entity.User;
import lk.ijse.dep9.service.custom.ToDoItemService;
import lk.ijse.dep9.service.util.Converter;
import lk.ijse.dep9.util.ConnectionUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ToDoItemServiceImpl implements ToDoItemService {
    private ToDoItemDAO toDoItemDAO;
    private final Converter converter=new Converter();


    public ToDoItemServiceImpl(){
        this.toDoItemDAO = DAOFactory.getInstance().getDAO(ConnectionUtil.getConnection(), DAOTypes.TODOITEM);
    }

    public void addNewToDoItem(ToDoItemDTO toDoItemDTO){
        ToDoItem toDoItem = converter.fromToDoItemDTO(toDoItemDTO);
        toDoItemDAO.save(toDoItem);
    }
    public List<ToDoItemDTO> getToDoItems(){
        List<ToDoItem> toDoItems=toDoItemDAO.findAll();
        return toDoItems.stream().map(converter::toToDoItemDTO).collect(Collectors.toList());

    }
    public void updateToDoItem(ToDoItemDTO toDoItemDTO){
        toDoItemDAO.update(converter.fromToDoItemDTO(toDoItemDTO));
    }
    public void deleteToDoItem(Integer id){

        toDoItemDAO.deleteById(id);
    }
    public void deleteAll(){
        toDoItemDAO.deleteAll();

    }
}
