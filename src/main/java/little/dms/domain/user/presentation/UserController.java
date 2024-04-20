package little.dms.domain.user.presentation;

import jakarta.validation.Valid;
import little.dms.domain.board.presentation.dto.request.CreateBoardRequest;
import little.dms.domain.user.presentation.dto.request.LoginRequest;
import little.dms.domain.user.presentation.dto.request.SignupRequest;
import little.dms.domain.user.service.LoginService;
import little.dms.domain.user.service.SignupService;
import little.dms.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SignupService signupService;
    private final LoginService loginService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TokenResponse signup(@RequestBody @Valid SignupRequest request) {
        return signupService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }
}
