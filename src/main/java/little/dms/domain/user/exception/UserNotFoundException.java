package little.dms.domain.user.exception;


import little.dms.global.error.exception.BusinessException;
import little.dms.global.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserNotFoundException();
    private UserNotFoundException(){
        super (ErrorCode.USER_NOT_FOUND);
    }
}