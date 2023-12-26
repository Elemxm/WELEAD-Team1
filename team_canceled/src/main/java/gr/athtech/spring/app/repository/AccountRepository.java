package gr.athtech.spring.app.repository;

import gr.athtech.spring.app.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long> {
    Account findByEmail(String email);
}
