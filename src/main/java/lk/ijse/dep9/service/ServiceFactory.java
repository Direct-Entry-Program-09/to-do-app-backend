package lk.ijse.dep9.service;

import lk.ijse.dep9.dao.SuperDAO;
import lk.ijse.dep9.dao.custom.impl.ToDoItemDAOImpl;
import lk.ijse.dep9.service.custom.impl.UserServiceImpl;

import java.sql.Connection;

public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    public ServiceFactory() {

    }
    public static ServiceFactory getInstance(){
        return (serviceFactory==null) ? serviceFactory=new ServiceFactory() : serviceFactory;
    }

    public <T extends SuperService> T getService(Connection connection, ServiceType serviceType){
        switch (serviceType){
            case USER:
                return (T) new UserServiceImpl(connection);
            case TODO:
                return (T) new ToDoItemDAOImpl(connection);
            default:
                return null;
        }
    }
}
