package lk.ijse.dep9.dto;

import lk.ijse.dep9.dto.util.Status;

import java.io.Serializable;

public class ToDoItemDTO implements Serializable {

    private Integer id;
    private String username;
    private String description;
    private Status status;

    public ToDoItemDTO() {
    }

    public ToDoItemDTO(Integer id, String username, String description, Status status) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ToDoItemDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
