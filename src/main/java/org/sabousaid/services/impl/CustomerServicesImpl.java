package org.sabousaid.services.impl;

import org.sabousaid.Repository.CustomerRepository;
import org.sabousaid.model.Customer;
import org.sabousaid.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Integer id, Customer updateCustomer) {
        /**
            updateCustomer.setId(id);
            return customerRepository.save(updateCustomer);
         */
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            updateCustomer.setId(customer.get().getId());
            return customerRepository.save(updateCustomer);
        }
        return null;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).get();
    }
}
