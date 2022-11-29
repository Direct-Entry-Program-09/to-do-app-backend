package lk.ijse.dep9.service.custom;

import com.github.javafaker.Faker;
import lk.ijse.dep9.dto.ToDoItemDTO;
import lk.ijse.dep9.dto.util.Status;
import lk.ijse.dep9.entity.ToDoItem;
import lk.ijse.dep9.service.ServiceFactory;
import lk.ijse.dep9.service.ServiceTypes;
import lk.ijse.dep9.service.SuperService;
import lk.ijse.dep9.util.ConnectionUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ToDoItemServiceTest {
    private Connection connection;
    private ToDoItemService toDoItemService;
    @BeforeEach
    void setUp() throws SQLException {
        connection= DriverManager.getConnection("jdbc:h2:mem:");

        try (BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/db-script.sql")))) {
            String s = bufferedReader1.lines().reduce((previous, current) -> previous + current).get();
            connection.createStatement().execute(s);
            ConnectionUtil.setConnection(connection);
            toDoItemService = ServiceFactory.getInstance().getService(ServiceTypes.TODOITEM);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.close();

    }


    void addNewToDoItem() {
        ToDoItemDTO toDoItemDTO = new ToDoItemDTO(4,"Ravindu","Create another task", Status.DONE);
        toDoItemService.addNewToDoItem(toDoItemDTO);
    }

    @Test
    void getToDoItems() {


    }

    @Test
    void updateToDoItem() {
//        new ToDoItemDTO(5,"")
//        toDoItemService.updateToDoItem();
    }

    @Test
    void deleteToDoItem() {
    }

    @Test
    void deleteAll() {
    }
}