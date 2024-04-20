package little.dms.domain.board.service;

import jakarta.transaction.Transactional;
import little.dms.domain.board.domain.Board;
import little.dms.domain.board.domain.repository.BoardRepository;
import little.dms.domain.board.exception.BoardNotFoundException;
import little.dms.domain.user.domain.User;
import little.dms.domain.user.exception.WriterMisMatchedException;
import little.dms.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteBoardService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public void execute(Long boardId) {
        User currentUser = userFacade.getCurrentUser();

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        if (!currentUser.equals(board.getUser())) {
            throw WriterMisMatchedException.EXCEPTION;
        }

        boardRepository.deleteById(boardId);

    }
}
