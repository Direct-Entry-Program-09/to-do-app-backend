package lk.ijse.dep9.service.custom.impl;

import lk.ijse.dep9.dao.custom.UserDAO;
import lk.ijse.dep9.dao.custom.impl.UserDAOImpl;
import lk.ijse.dep9.dto.UserDTO;
import lk.ijse.dep9.service.ServiceFactory;
import lk.ijse.dep9.service.ServiceType;
import lk.ijse.dep9.service.custom.UserService;
import lk.ijse.dep9.service.exception.NotFoundException;
import lk.ijse.dep9.util.ConnectionUtil;
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

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserService userService;
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException, URISyntaxException, IOException {
        connection = DriverManager.getConnection("jdbc:h2:mem:dep9_todo");
        List<String> lines = Files.readAllLines(Paths.get(this.getClass().getResource("/db-script2.sql").toURI()));
        String dbScriptContent = lines.stream().reduce((previous, current) ->
                previous + '\n' + current).get();
        Statement statement = connection.createStatement();
        statement.execute(dbScriptContent);
        ConnectionUtil.setConnection(connection);
        userService= ServiceFactory.getInstance().getService(connection, ServiceType.USER);
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    void addNewUser() {
       UserDTO userDTO=new UserDTO("anuladiss","anula123","anula111dissanayaka");
       assertDoesNotThrow(()->userService.addNewUser(userDTO));
    }

    @Test
    void updateUserDetails() {
        UserDTO userDTO=new UserDTO("nipunija","afsff","njnfjasfsf");
        UserDTO userDTO2=new UserDTO("nipunijaeee","afsff","njnfjasfsf");
        assertDoesNotThrow(()->userService.updateUserDetails(userDTO));
        assertThrows(NotFoundException.class,()->userService.updateUserDetails(userDTO2));
    }

    @Test
    void getUserDetails() {
        UserDTO nipunija1 = userService.getUserDetails("nipunija");
        assertEquals(nipunija1.getUserName(),"nipunija");
        assertThrows(NotFoundException.class,()->userService.getUserDetails("nipunija222"));
    }
}