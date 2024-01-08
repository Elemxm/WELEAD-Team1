package gr.athtech.spring.app.service;

import gr.athtech.spring.app.model.Account;
import gr.athtech.spring.app.model.Address;
import gr.athtech.spring.app.model.Order;
import gr.athtech.spring.app.repository.BaseRepository;
import gr.athtech.spring.app.repository.AccountRepository;
import gr.athtech.spring.app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
    private final AccountRepository accountRepository;
    private final OrderRepository orderRepository;

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

    //Check this again!
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
        accountRepository.update(account);

        if (accountRepository.exists(account)) {
            if (password == null) {
                throw new IllegalArgumentException("Password cannot be null");
            }

            account.setPassword(password);
            accountRepository.update(account);
        }
        else {
            throw new NoSuchElementException("Account not found");
        }

    }

    @Override
    public void addAddress(Account account, Address address) {

        if( address.getStreetName() == null || address.getStreetNumber() == null || address.getPostalCode() == null) {
            throw new IllegalArgumentException("Address field cannot be null");
        } else {
            if (account.getAddresses().contains(address)) {
                throw new IllegalStateException("Address already exists for the account");
            } else {
                account.getAddresses().add(address);
                accountRepository.update(account);
            }
        }

    }


    //pending
    @Override
    public void logout() {

    }

    @Override
    public List<Order> viewPlacedOrders(Account account) {
        return orderRepository.findAllAccountOrders(account);
    }
}
