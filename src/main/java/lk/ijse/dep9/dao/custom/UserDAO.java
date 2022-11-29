package lk.ijse.dep9.dao.custom;

import lk.ijse.dep9.dao.SuperDAO;
import lk.ijse.dep9.entity.SuperEntity;

public interface UserDAO<T extends SuperEntity, ID> extends SuperDAO {
    void createUser();
    void deleteUser();

}
