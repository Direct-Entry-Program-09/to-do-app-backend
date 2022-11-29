package lk.ijse.dep9.service;

import lk.ijse.dep9.service.custom.impl.ToDoItemServiceImpl;
import lk.ijse.dep9.service.custom.impl.UserServiceImpl;

public class ServiceFactory {
    private static ServiceFactory servicefactory=new ServiceFactory();

    private ServiceFactory(){

    }
    public static ServiceFactory getInstance(){
        return servicefactory;
    }

    public <T extends SuperService>T getService(ServiceTypes serviceTypes){
        final SuperService service;
        switch (serviceTypes){
            case USER:
                service=new UserServiceImpl();
                break;
            case TODOITEM:
                service=new ToDoItemServiceImpl();
                break;
            default:
                service=null;
        }
        return (T) service;
    }
}
