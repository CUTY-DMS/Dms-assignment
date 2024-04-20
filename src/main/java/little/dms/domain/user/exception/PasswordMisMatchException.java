package little.dms.domain.user.exception;


import little.dms.global.error.exception.BusinessException;
import little.dms.global.error.exception.ErrorCode;

public class PasswordMisMatchException extends BusinessException {
    public static final BusinessException EXCEPTION = new PasswordMisMatchException();
    private PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}