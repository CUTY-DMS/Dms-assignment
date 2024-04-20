package little.dms.domain.user.exception;

import little.dms.global.error.exception.BusinessException;
import little.dms.global.error.exception.ErrorCode;

public class AccountIdAlreadyExistsException extends BusinessException {
    public static final BusinessException EXCEPTION = new AccountIdAlreadyExistsException();
    private AccountIdAlreadyExistsException(){
        super(ErrorCode.ACCOUNT_ID_ALREADY_EXISTS);
    }
}
