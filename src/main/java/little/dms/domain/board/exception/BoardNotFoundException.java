package little.dms.domain.board.exception;


import little.dms.global.error.exception.BusinessException;
import little.dms.global.error.exception.ErrorCode;

public class BoardNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new BoardNotFoundException();
    private BoardNotFoundException(){
        super (ErrorCode.BOARD_NOT_FOUND);
    }
}