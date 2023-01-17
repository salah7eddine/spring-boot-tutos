package org.sabousaid.services;

import org.sabousaid.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerServices {
    List<Customer> getCustomers();

    Customer saveCustomer(Customer newCustomer);

    void deleteCustomer(Integer id);

    Customer updateCustomer(Integer id, Customer updateCustomer);

    Customer getCustomerById(Integer id);
}
