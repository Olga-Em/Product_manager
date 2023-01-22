package ru.netology.product.exception;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(int id) {
        super("This id = " + id + " is busy");
    }
}
