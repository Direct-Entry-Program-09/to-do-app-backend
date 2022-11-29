package lk.ijse.dep9.dao;

import lk.ijse.dep9.dao.custom.exception.ConstraintViolationException;
import lk.ijse.dep9.entity.SuperEntity;

import java.util.List;
import java.util.Optional;

public interface CrudDAO<T extends SuperEntity,ID> extends SuperDAO{
    long count();
    void deleteById(ID pk) throws ConstraintViolationException;
    boolean existsById(ID pk);
    List<T> findAll();
    Optional<T> findById(ID pk);
    T save(T entity) throws ConstraintViolationException;
    T update(T entity) throws ConstraintViolationException;


}
