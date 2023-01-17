package org.sabousaid.web;

import org.sabousaid.model.Customer;
import org.sabousaid.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return this.customerServices.getCustomers();
    }
    @GetMapping("/customers/{customerId}")
    public Customer getCustomers(@PathVariable("customerId") Integer id) {
        return this.customerServices.getCustomerById(id);
    }

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer newCustomer) {
        return this.customerServices.saveCustomer(newCustomer);
    }

    @DeleteMapping("/customer/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        this.customerServices.deleteCustomer(id);
    }

    @PutMapping("/customer/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") Integer id, @RequestBody Customer updateCustomer) {
        return this.customerServices.updateCustomer(id, updateCustomer);
    }
}
