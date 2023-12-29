package vn.edu.ptit.toiec.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.ptit.toiec.data.entities.Authority;
import vn.edu.ptit.toiec.data.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    List<User> findAllByRolesContains(Authority authority);

    User findByEmail(User user);

    @Query(value = "Select distinct u.* from users u join history_exam h on u.id = h.user_id",nativeQuery = true)
    List<User> findAllByRegisteredAccount();
}
