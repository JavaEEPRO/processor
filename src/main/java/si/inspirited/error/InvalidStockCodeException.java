package si.inspirited.error;

public class InvalidStockCodeException extends RuntimeException {

    private static final long serialVersionUID = 1973103339751279217L;

    public InvalidStockCodeException() {
        super();
    }

    public InvalidStockCodeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidStockCodeException(final String message) {
        super(message);
    }

    public InvalidStockCodeException(final Throwable cause) {
        super(cause);
    }
}
