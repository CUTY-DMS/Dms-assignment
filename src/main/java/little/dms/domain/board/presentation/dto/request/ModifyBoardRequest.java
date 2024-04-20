package little.dms.domain.board.presentation.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModifyBoardRequest {

    @NotNull(message = "title은 null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(max = 50, message = "title은 최대 50자까지 가능합니다.")
    private String title;

    @NotNull(message = "content은 null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(max = 5000, message = "content은 최대 5000자까지 가능합니다.")
    private String content;

}
