package calculator.api.rest.exception;

/**
 * @author Judiao Mbaua
 *
 */
public class InvalidOperatorException extends BusinessException {
    public static final long serialVersionId=2343454l; 
    public InvalidOperatorException(final String message) {
        super(message);
    }
}
