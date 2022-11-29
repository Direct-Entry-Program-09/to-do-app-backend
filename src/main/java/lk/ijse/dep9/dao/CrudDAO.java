package lk.ijse.dep9.dao;

import lk.ijse.dep9.dao.custom.exception.ConstraintViolationException;
import lk.ijse.dep9.entity.SuperEntity;
import lk.ijse.dep9.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<T extends SuperEntity,ID extends Serializable> extends SuperDAO{
    public long count();
    public void deleteById(ID id) throws ConstraintViolationException;
    public boolean existsById(ID pk);
    public List<T> findAll();
    public Optional<T> findById(ID pk);
    public Object save(T entity) throws ConstraintViolationException;
    public Object update(T entity) throws ConstraintViolationException;

}
