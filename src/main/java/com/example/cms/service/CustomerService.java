package com.example.cms.service;

import com.example.cms.dao.CustomerDAO;
import com.example.cms.exception.CustomerNotFoundException;
import com.example.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers(){
       return customerDAO.findAll();
//        return customerList;
    }

    public Customer getCustomer(int customerId){

        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException(("Customer Record is not available"));
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer) {
        customer.setCustomerId(customerId);
        return customerDAO.save(customer);


    }
    public void deleteCustomer(int customerId){
        customerDAO.deleteById(customerId);
    }
}
