package vn.edu.ptit.toiec.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.ptit.toiec.data.entities.Authority;
import vn.edu.ptit.toiec.data.entities.AuthorityName;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Authority findAllByName(AuthorityName name);

    Boolean existsByName(AuthorityName name);

    Authority findByName(AuthorityName name);
}
