package little.dms.domain.board.presentation;

import jakarta.validation.Valid;
import little.dms.domain.board.presentation.dto.request.CreateBoardRequest;
import little.dms.domain.board.presentation.dto.request.ModifyBoardRequest;
import little.dms.domain.board.presentation.dto.response.BoardResponse;
import little.dms.domain.board.service.CreateBoardService;
import little.dms.domain.board.service.DeleteBoardService;
import little.dms.domain.board.service.GetBoardService;
import little.dms.domain.board.service.ModifyBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final CreateBoardService createBoardService;
    private final ModifyBoardService modifyBoardService;
    private final DeleteBoardService deleteBoardService;
    private final GetBoardService getBoardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPetition(@RequestBody @Valid CreateBoardRequest request) {
        createBoardService.execute(request);
    }

    @PatchMapping("/{board-id}")
    public void modifyPetition(@PathVariable("board-id") Long id, @RequestBody @Valid ModifyBoardRequest request) {
        modifyBoardService.execute(id, request);
    }

    @DeleteMapping("/{board-id}")
    public void deleteBoard(@PathVariable("board-id") Long id) {
        deleteBoardService.execute(id);
    }

    @GetMapping("/{board-id}")
    public BoardResponse getBoard(@PathVariable("board-id") Long id) {
        return getBoardService.execute(id);
    }

}
