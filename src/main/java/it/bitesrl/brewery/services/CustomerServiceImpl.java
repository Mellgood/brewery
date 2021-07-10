package it.bitesrl.brewery.services;

import it.bitesrl.brewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Carlo")
                .build();

    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        //todo: would save the entity on a persistence layer
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto) {
        //todo: would save the entity on a persistence layer
        log.error("Not implemented yet... returning null");
        return null;
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        //todo: would delete the entity on a persistence layer
        log.error("not implemented yet: deleting a customer...");
    }


}
