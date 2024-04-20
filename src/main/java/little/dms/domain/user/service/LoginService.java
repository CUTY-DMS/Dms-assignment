package little.dms.domain.user.service;

import little.dms.domain.user.domain.User;
import little.dms.domain.user.domain.repository.UserRepository;
import little.dms.domain.user.domain.type.Role;
import little.dms.domain.user.exception.PasswordMisMatchException;
import little.dms.domain.user.exception.UserAlreadyExistException;
import little.dms.domain.user.exception.UserNotFoundException;
import little.dms.domain.user.presentation.dto.request.LoginRequest;
import little.dms.domain.user.presentation.dto.request.SignupRequest;
import little.dms.global.security.TokenResponse;
import little.dms.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse execute(LoginRequest request) {

        User user = userRepository.findByAccountId(request.getAccountId())
            .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw PasswordMisMatchException.EXCEPTION;
        }

        return jwtTokenProvider.createToken(request.getAccountId());
    }
}
