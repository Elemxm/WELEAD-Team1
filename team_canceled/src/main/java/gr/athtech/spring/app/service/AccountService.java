package gr.athtech.spring.app.service;

import gr.athtech.spring.app.model.Account;
import gr.athtech.spring.app.model.Address;
import gr.athtech.spring.app.model.Order;

import java.util.List;

public interface AccountService extends BaseService<Account, Long> {
    Account findByEmail(String email);
    Account findByPhone(Integer phone);
    boolean login(String email, String password);   //add session
    boolean signup(Account account);

    void changePassword(Account account, String password);

    void addAddress(Account account, Address address);

    List<Order> viewPlacedOrders(Account account);

    void logout();  //pending
}
