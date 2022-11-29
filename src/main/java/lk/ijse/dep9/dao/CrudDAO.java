package lk.ijse.dep9.dao;

import lk.ijse.dep9.entity.SuperEntity;

public interface CrudDAO<T extends SuperEntity,ID> extends SuperDAO{
    T save(T entity);
    T update(T entity);
    void delete(ID id);

}
