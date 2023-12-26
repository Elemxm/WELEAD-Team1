package gr.athtech.spring.app.service;

import gr.athtech.spring.app.model.Account;
import gr.athtech.spring.app.model.Address;

public interface AddressService extends BaseService<Address, Long> {
    Address addAddress(Account account);
}
