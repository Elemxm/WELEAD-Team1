package gr.athtech.spring.app.service;

import gr.athtech.spring.app.model.Account;
import gr.athtech.spring.app.repository.BaseRepository;
import gr.athtech.spring.app.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    protected BaseRepository<Account, Long> getRepository() {
        return accountRepository;
    }

    @Override
    public Account findByEmail(final String email) {
        return accountRepository.findByEmail(email);
    }

    public Account findByPhone(final Integer phone) { return accountRepository.
            findByPhone(phone); }

    public Account signup(String email, Integer phone, String password) {
        //1) Check through Repository if everything is ok!!!
        accountRepository.signup(email, phone, password);
        //2) Create new account with the given data!
        Account newAccount = new Account();
        newAccount.setEmail(email);
        newAccount.setPhone(phone);
        newAccount.setPassword(password);

        //3) Save and return if the new account is successfully saved!
        return newAccount;
    }

    @Override
    public boolean login(final String email, String password) {
        // Retrieve user by username from the repository
        Account account = accountRepository.findByEmail(email);

        // Check if the user exists and the provided password is correct
        return account != null && password.equals(account.getPassword());
    }

    //pending
    @Override
    public void logout() {

    }
}
