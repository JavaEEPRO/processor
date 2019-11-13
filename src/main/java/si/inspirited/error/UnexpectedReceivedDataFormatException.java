package si.inspirited.error;

public class UnexpectedReceivedDataFormatException extends RuntimeException {

    private static final long serialVersionUID = 7871330937344187443L;

    public UnexpectedReceivedDataFormatException() {
        super();
    }

    public UnexpectedReceivedDataFormatException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UnexpectedReceivedDataFormatException(final String message) {
        super(message);
    }

    public UnexpectedReceivedDataFormatException(final Throwable cause) {
        super(cause);
    }
}
