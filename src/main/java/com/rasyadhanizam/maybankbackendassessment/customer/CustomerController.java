package com.rasyadhanizam.maybankbackendassessment.customer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
//import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    Logger logger = (Logger) LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomer() {
        logger.trace("Get method accessed");
        return customerService.getCustomer();
    }

    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer){
        log.debug("Post method accessed");
        customerService.addNewCustomer(customer);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId){
        log.debug("Delete method accessed");
        customerService.deleteCustomer(customerId);
    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Long customerId,
            @RequestParam(required = false) String bank,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) LocalDate dob,
            @RequestParam(required = false) String number,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Float balance,
            @RequestParam(required = false) String iban){
        log.debug("Put method accessed");
        customerService.updateCustomer(customerId, bank, name, email, dob, number, type, balance, iban);
    }
}
