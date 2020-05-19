package org.system.exception;

public class NoRowUpdatedException extends RuntimeException {
    public NoRowUpdatedException(String message) {
        super(message);
    }
}
