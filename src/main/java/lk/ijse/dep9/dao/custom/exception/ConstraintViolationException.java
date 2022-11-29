package lk.ijse.dep9.dao.custom.exception;

public class ConstraintViolationException extends RuntimeException {
    public ConstraintViolationException(String reason, Throwable cause) {
        super(reason, cause);
    }

}
