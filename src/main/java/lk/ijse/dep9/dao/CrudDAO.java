package lk.ijse.dep9.dao;

import lk.ijse.dep9.entity.SuperEntity;
import lk.ijse.dep9.entity.User;

import java.io.Serializable;

public interface CrudDAO<T extends SuperEntity,ID extends Serializable> extends SuperDAO{
    Object create(T entity);
    void delete(ID pk);

}
