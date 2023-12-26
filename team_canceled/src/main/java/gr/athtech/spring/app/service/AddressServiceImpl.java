package gr.athtech.spring.app.service;

import gr.athtech.spring.app.model.Address;
import gr.athtech.spring.app.repository.BaseRepository;
import gr.athtech.spring.app.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class AddressServiceImpl extends BaseServiceImpl<Address> implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    protected BaseRepository<Address, Long> getRepository() {
        return addressRepository;
    }
}
