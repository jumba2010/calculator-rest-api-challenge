package calculator.api.rest.exception;
/**
 * @author Judiao Mbaua
 *
 */
public class BusinessException extends RuntimeException {
    public static final long serialVersionId=23403454l; 
    public BusinessException(final String message) {
        super(message);
    }
}
