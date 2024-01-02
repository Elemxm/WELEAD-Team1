package gr.athtech.spring.app.service;

import gr.athtech.spring.app.model.Account;
import gr.athtech.spring.app.model.Address;
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

    public Account findByPhone(final Integer phone) {
        return accountRepository.findByPhone(phone);
    }

    public boolean signup(Account account) {
        //1) Check through Repository account already exists
        if (accountRepository.exists(account)) {
            logger.warn("User already exists");
            return false;
        } else {
            //2) Create new account
            accountRepository.create(account);
            return true;
        }
    }

    //add session
    @Override
    public boolean login(final String email, String password) {
        // Retrieve user by username from the repository
        Account account = accountRepository.findByEmail(email);

        // Check if the user exists and the provided password is correct
        return account != null && password.equals(account.getPassword());
    }

    @Override
    public void changePassword(Account account, String password) {
        if (accountRepository.exists(account)) {
            account.setPassword(password);
        }

        accountRepository.update(account);
    }

    @Override
    public void addAddress(Account account, Address address) {
        account.getAddresses().add(address);
        accountRepository.update(account);
    }

    //pending
    @Override
    public void logout() {

    }
}
