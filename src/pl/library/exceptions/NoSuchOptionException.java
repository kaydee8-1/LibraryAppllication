package pl.library.exceptions;

import java.rmi.server.ExportException;

public class NoSuchOptionException extends Exception {
    public NoSuchOptionException(String message) {
        super(message);
    }
}
