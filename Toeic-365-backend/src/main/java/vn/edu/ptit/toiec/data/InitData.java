package vn.edu.ptit.toiec.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import vn.edu.ptit.toiec.data.entities.Authority;
import vn.edu.ptit.toiec.data.entities.AuthorityName;
import vn.edu.ptit.toiec.data.repository.AuthorityRepository;

@Component
public class InitData implements ApplicationRunner {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!authorityRepository.existsByName(AuthorityName.ROLE_USER)){
            authorityRepository.save(new Authority(AuthorityName.ROLE_USER));
        }
        if (!authorityRepository.existsByName(AuthorityName.ROLE_ADMIN)){
            authorityRepository.save(new Authority(AuthorityName.ROLE_ADMIN));
        }
    }
}
