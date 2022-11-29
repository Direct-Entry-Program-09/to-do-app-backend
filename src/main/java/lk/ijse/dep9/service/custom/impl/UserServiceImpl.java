package lk.ijse.dep9.service.custom.impl;

import lk.ijse.dep9.dao.DAOFactory;
import lk.ijse.dep9.dao.DaoTypes;
import lk.ijse.dep9.dao.custom.UserDAO;
import lk.ijse.dep9.dto.UserDTO;
import lk.ijse.dep9.entity.User;
import lk.ijse.dep9.service.custom.UserService;
import lk.ijse.dep9.service.exception.NotFoundException;
import lk.ijse.dep9.service.util.Convertor;
import lk.ijse.dep9.util.ConnectionUtil;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    private Connection connection;
    private Convertor convertor=new Convertor();

    public UserServiceImpl(Connection connection) {
        this.userDAO = DAOFactory.getInstance().getDAO(ConnectionUtil.getConnection(), DaoTypes.USER);
        this.connection=connection;
    }

    @Override
    public void addNewUser(UserDTO userDTO) {
        userDAO.save(convertor.toUser(userDTO));
    }

    @Override
    public void updateUserDetails(UserDTO userDTO) {
        if (!userDAO.existsById(userDTO.getUserName())) throw new NotFoundException("Not such user");
        userDAO.update(convertor.toUser(userDTO));
    }

    @Override
    public UserDTO getUserDetails(String username) {
        if (!userDAO.existsById(username)) throw new NotFoundException("User not available");
        return userDAO.findById(username).map(convertor::toUserDTO).orElseThrow(()->new NotFoundException("user does not exists"));
    }

    @Override
    public List<UserDTO> findUsers(String query, int size, int page) {
        return null;
    }
}
