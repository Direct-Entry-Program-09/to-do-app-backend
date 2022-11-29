package lk.ijse.dep9.service.util;

import lk.ijse.dep9.dao.custom.ToDoItemDAO;
import lk.ijse.dep9.dto.ToDoItemDTO;
import lk.ijse.dep9.entity.ToDoItem;
import org.modelmapper.ModelMapper;

import java.sql.Date;
import java.time.LocalDate;

public class Converter {
private ModelMapper modelMapper;

    public Converter(){
        this.modelMapper=new ModelMapper();
        modelMapper.typeMap(LocalDate.class, Date.class).setConverter(mc->Date.valueOf(mc.getSource()));
    }
    public ToDoItemDTO toToDoItemDTO(ToDoItem toDoItem){
        return modelMapper.map(toDoItem,ToDoItemDTO.class);
    }
    public ToDoItem fromToDoItemDTO(ToDoItemDTO toDoItemDTO){
        return modelMapper.map(toDoItemDTO, ToDoItem.class);
    }
}
