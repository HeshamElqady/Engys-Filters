package it.elqady.hesham.engys.filters.exception;

public class FiltersException extends RuntimeException {

    public FiltersException(String message) {
        super(message);
    }

    public FiltersException(String message, Throwable cause) {
        super(message, cause);
    }

    public FiltersException(Throwable cause) {
        super(cause);
    }

    public FiltersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
