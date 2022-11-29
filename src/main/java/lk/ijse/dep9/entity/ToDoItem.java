package lk.ijse.dep9.entity;

import lk.ijse.dep9.dao.util.status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoItem implements Serializable, SuperEntity {
    private int id;
    private String username;
    private String description;
    private status status;

    public ToDoItem(String username, String description, lk.ijse.dep9.dao.util.status status) {
        this.username = username;
        this.description = description;
        this.status = status;
    }
}
