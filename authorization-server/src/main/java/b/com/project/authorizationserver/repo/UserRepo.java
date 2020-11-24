package b.com.project.authorizationserver.repo;

import b.com.project.authorizationserver.model.CustomUserDetail;
import b.com.project.authorizationserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String userName);
}
