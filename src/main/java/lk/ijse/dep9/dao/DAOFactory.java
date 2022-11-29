package lk.ijse.dep9.dao;

import lk.ijse.dep9.dao.custom.impl.ToDoItemDAOImpl;
import lk.ijse.dep9.dao.custom.impl.UserDAOImpl;
import lk.ijse.dep9.service.custom.impl.ToDoItemServiceImpl;

import java.sql.Connection;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){

    }
    public static DAOFactory getInstance() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(Connection connection, DAOTypes daoType) {
        switch (daoType) {
            case USER:
                return (T) new UserDAOImpl(connection);
            case TODOITEM:
                return (T) new ToDoItemDAOImpl(connection);
            default:
                return null;
        }
    }
}
