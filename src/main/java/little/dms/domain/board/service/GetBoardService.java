package little.dms.domain.board.service;

import little.dms.domain.board.domain.Board;
import little.dms.domain.board.domain.repository.BoardRepository;
import little.dms.domain.board.exception.BoardNotFoundException;
import little.dms.domain.board.presentation.dto.response.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetBoardService {

    private final BoardRepository boardRepository;

    public BoardResponse execute(Long boardId) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        return new BoardResponse(board);
    }
}
