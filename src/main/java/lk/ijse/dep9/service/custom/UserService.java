package lk.ijse.dep9.service.custom;

import lk.ijse.dep9.dto.UserDTO;
import lk.ijse.dep9.service.SuperService;

import java.util.List;

public interface UserService extends SuperService {
    void addNewUser(UserDTO userDTO) ;
    void updateUserDetails(UserDTO userDTO) ;
    UserDTO getUserDetails(String username) ;
    List<UserDTO> findUsers(String query, int size, int page);

}
