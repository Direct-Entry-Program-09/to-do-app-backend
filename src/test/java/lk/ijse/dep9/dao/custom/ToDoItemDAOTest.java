package lk.ijse.dep9.dao.custom;

import com.github.javafaker.Faker;
import lk.ijse.dep9.dao.custom.impl.ToDoItemDAOImpl;
import lk.ijse.dep9.dao.util.status;
import lk.ijse.dep9.entity.ToDoItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoItemDAOTest {
    private ToDoItemDAOImpl toDoItemDAO;

    Connection connection;


    @BeforeEach
    void setUp() throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        connection = DriverManager.getConnection("jdbc:h2:mem:dep9_todo");
        List<String> lines = Files.readAllLines(Paths.get(ToDoItemDAOTest.class.getResource("/db_script1.sql").toURI()));
        String dbScriptContent = lines.stream().reduce((previous, current) -> previous + '\n' + current).get();
        Statement statement = connection.createStatement();
        statement.execute(dbScriptContent);
        this.toDoItemDAO=new ToDoItemDAOImpl(connection);
    }

    @AfterEach
    void afterAll() throws SQLException {
        connection.close();
    }

    @Test
    void saveMember(){
        ToDoItem expectedToDoItem = new ToDoItem(5,"Dinithi","Complete Test", status.DONE);
        System.out.println(expectedToDoItem);
        ToDoItem todo = toDoItemDAO.save(expectedToDoItem);
        assertEquals(expectedToDoItem,todo);
    }
    @Test
    void updateMember(){
        ToDoItem expectedToDoItem = new ToDoItem(3, "Rashmi", "Create next", status.NOTDONE);
        ToDoItem updatedToDoItem = toDoItemDAO.update(expectedToDoItem);
        assertEquals(expectedToDoItem,updatedToDoItem);
    }
    @Test
    void deleteAll() {
        toDoItemDAO.deleteAll();
        assertEquals(0,toDoItemDAO.count());
    }
}