package little.dms.domain.board.presentation.dto.response;

import little.dms.domain.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BoardResponse {

    private Long id;

    private String title;

    private String content;

    public BoardResponse(Board board) {
        id = board.getUser().getId();
        title = board.getTitle();
        content = board.getContent();
    }
}
