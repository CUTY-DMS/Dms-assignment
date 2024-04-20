package little.dms.domain.user.facade;

import little.dms.domain.user.domain.User;
import little.dms.domain.user.domain.repository.UserRepository;
import little.dms.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByAccountId(accountId)
            .orElseThrow(() -> UserNotFoundException.EXCEPTION);

    }
}
