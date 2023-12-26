package gr.athtech.spring.app.repository;

import gr.athtech.spring.app.model.Address;
import gr.athtech.spring.app.model.Order;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AddressRepositoryImpl extends BaseRepositoryImpl<Address> implements AddressRepository {

}
