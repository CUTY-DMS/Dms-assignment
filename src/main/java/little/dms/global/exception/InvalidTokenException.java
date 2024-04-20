package little.dms.global.exception;


import little.dms.global.error.exception.BusinessException;
import little.dms.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {
    public static final BusinessException EXCEPTION = new InvalidTokenException();
    private InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN);

    }
}
