package app.soft_tenders.sims.config;

import app.soft_tenders.sims.entity.User;
import app.soft_tenders.sims.repository.UserRepo;
import app.soft_tenders.sims.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = userRepo.findByEmailId(username);
        if (users.isEmpty()) throw new UsernameNotFoundException(Constants.userNotFoundWithEmail(username));
        User user = users.getFirst();

        if (!user.isActive()) throw new RuntimeException(Constants.USER_ACCOUNT_DEACTIVATED);

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmailId())
                .password(user.getPassword())
                .roles("USER") // ToDo:Fetch the roles from DB
                .build();
    }
}
