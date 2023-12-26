package gr.athtech.spring.app.service;

import gr.athtech.spring.app.model.Account;

public interface AccountService extends BaseService<Account, Long> {
    Account findByEmail(String email);

    boolean login(String email, String password);

    void logout();  //pending...
}
