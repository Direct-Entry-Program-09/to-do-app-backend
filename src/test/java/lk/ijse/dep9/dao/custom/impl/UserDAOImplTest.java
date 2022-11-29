package lk.ijse.dep9.dao.custom.impl;

import lk.ijse.dep9.dao.custom.exception.ConstraintViolationException;
import lk.ijse.dep9.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOImplTest {
    private UserDAOImpl userDAOImpl;
    private Connection connection;
    @BeforeAll
    static void beforeAll() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @BeforeEach
    void setUp() throws SQLException, URISyntaxException, IOException {
            connection = DriverManager.getConnection("jdbc:h2:mem:dep9_todo");
            List<String> lines = Files.readAllLines(Paths.get(this.getClass().getResource("/db-script2.sql").toURI()));
            String dbScriptContent = lines.stream().reduce((previous, current) ->
                    previous + '\n' + current).get();
            Statement statement = connection.createStatement();
            statement.execute(dbScriptContent);
            this.userDAOImpl=new UserDAOImpl(connection);
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    void deleteById() {
        try {
            userDAOImpl.deleteById("pavijaya");
        }catch (ConstraintViolationException e){
            System.out.println("Failed to delte the user");
        }
    }

    @Test
    void existsById() {
        boolean actualValue = userDAOImpl.existsById("nipunija");
        assertTrue(actualValue==true);
    }

    @Test
    void findById() {
        Optional<User> memberById = userDAOImpl.findById("nipunija");
        assertTrue(memberById.isPresent()==true);
    }

    @Test
    void save() {
        User user=new User("nipunijaya2", "nipu1234", "nipuni pavithra");
        User saveObject = (User) userDAOImpl.save(user);
        assertEquals(saveObject.getUsername(),user.getUsername());
    }
}