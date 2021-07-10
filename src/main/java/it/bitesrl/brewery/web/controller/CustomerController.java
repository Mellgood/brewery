package it.bitesrl.brewery.web.controller;

import it.bitesrl.brewery.services.CustomerService;
import it.bitesrl.brewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postCustomer(CustomerDto customerDto){

        CustomerDto savedDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        //todo: add hostname to url
        headers.add("Location", "/api/v1/customer" + savedDto.getId().toString());

        return new ResponseEntity(savedDto, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putCustomer(@PathVariable UUID customerId, CustomerDto customerDto){

        CustomerDto newCustomerDto = customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID customerId){
        customerService.deleteCustomer(customerId);
    }
}
