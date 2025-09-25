package br.com.stapassoli.crud.exeption;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

}
