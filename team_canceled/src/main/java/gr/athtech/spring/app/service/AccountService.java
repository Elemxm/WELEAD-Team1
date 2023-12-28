package gr.athtech.spring.app.service;

import gr.athtech.spring.app.model.Account;

public interface AccountService extends BaseService<Account, Long> {
    Account findByEmail(String email);
    Account findByPhone(Integer phone);
    boolean login(String email, String password);
    Account signup(String email, Integer phone, String password);
    void logout();  //pending...
}
