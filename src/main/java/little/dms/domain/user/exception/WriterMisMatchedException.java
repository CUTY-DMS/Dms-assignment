package little.dms.domain.user.exception;


import little.dms.global.error.exception.BusinessException;
import little.dms.global.error.exception.ErrorCode;

public class WriterMisMatchedException extends BusinessException {
    public static final BusinessException EXCEPTION = new WriterMisMatchedException();
    private WriterMisMatchedException(){
        super(ErrorCode.WRITER_MISMATCH);
    }
}
