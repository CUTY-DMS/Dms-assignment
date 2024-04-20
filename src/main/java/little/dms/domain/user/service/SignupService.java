package little.dms.domain.user.service;

import little.dms.domain.user.domain.User;
import little.dms.domain.user.domain.repository.UserRepository;
import little.dms.domain.user.domain.type.Role;
import little.dms.domain.user.exception.UserAlreadyExistException;
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
public class SignupService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse execute(SignupRequest request) {

        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        String password = passwordEncoder.encode(request.getPassword());

        userRepository.save(
            User.builder()
                .accountId(request.getAccountId())
                .userName(request.getUserName())
                .password(password)
                .role(Role.STUDENT)
                .build()
        );

        return jwtTokenProvider.createToken(request.getAccountId());
    }
}
