package com.rasyadhanizam.maybankbackendassessment.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @Transactional
    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if (customerOptional.isPresent()){
            throw new IllegalStateException("email already in the system");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId) {
        boolean exist = customerRepository.existsById(customerId);
        if (!exist) {
            throw new IllegalStateException("customer id " + customerId + " does not exist");
        }
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(Long customerId, String bank, String name, String email, LocalDate dob, String number, String type, Float balance, String iban){
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new IllegalStateException("customer id " + customerId + " does not exist"));

        if (bank != null && bank.length() > 0 && !Objects.equals(customer.getBank(), bank)) {
            customer.setBank(bank);
        }
        if (name != null && name.length() > 0 && !Objects.equals(customer.getName(), name)) {
            customer.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(customer.getEmail(), email)) {
            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
            if (customerOptional.isPresent()){
                throw new IllegalStateException("email already in the system");
            }
            customer.setEmail(email);
        }
        if (dob != null && !Objects.equals(customer.getDob(), dob)) {
            customer.setDob(dob);
        }
        if (number != null && number.length() > 0 && !Objects.equals(customer.getNumber(), number)) {
            customer.setNumber(number);
        }
        if (type != null && type.length() > 0 && !Objects.equals(customer.getType(), type)) {
            customer.setType(type);
        }
        if (balance != null && !Objects.equals(customer.getBalance(), balance)) {
            customer.setBalance(balance);
        }
        if (iban != null && iban.length() > 0 && !Objects.equals(customer.getiban(), iban)) {
            customer.setiban(iban);
        }
    }
}
