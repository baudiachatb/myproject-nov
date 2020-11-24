package b.com.project.authorizationserver.service;

import b.com.project.authorizationserver.model.CustomUserDetail;
import b.com.project.authorizationserver.model.User;
import b.com.project.authorizationserver.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userServiceDetailImpl")
public class UserServiceDetailImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> userDetail = userRepo.findUserByUsername(s);
        CustomUserDetail customUserDetail = new CustomUserDetail(userDetail.get());
        userDetail.orElseThrow(() -> new UsernameNotFoundException("User name not found"));
        new AccountStatusUserDetailsChecker().check(customUserDetail);
        return customUserDetail;
    }
}
