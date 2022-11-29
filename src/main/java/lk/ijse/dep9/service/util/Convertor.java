package lk.ijse.dep9.service.util;

import lk.ijse.dep9.dto.UserDTO;
import lk.ijse.dep9.entity.User;
import org.modelmapper.ModelMapper;

public class Convertor {
    private ModelMapper mapper;

    public Convertor() {
        this.mapper = new ModelMapper();
    }

    public UserDTO toUserDTO(User user){
        mapper.typeMap(User.class,UserDTO.class).addMapping(User::getUsername,UserDTO::setUserName);
        mapper.typeMap(User.class,UserDTO.class).addMapping(User::getFullName,UserDTO::setFullName);
        return mapper.map(user,UserDTO.class);
    }
    public User toUser(UserDTO userDTO){
        return mapper.map(userDTO,User.class);
    }
}
