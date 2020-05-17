package org.system.exception;

public class RowNotFoundException extends RuntimeException {
    public RowNotFoundException(String s) {
        super(s);
    }
}
