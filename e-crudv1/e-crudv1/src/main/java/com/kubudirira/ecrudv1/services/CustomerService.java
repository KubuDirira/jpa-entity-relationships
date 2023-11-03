package com.kubudirira.ecrudv1.services;



import com.kubudirira.ecrudv1.models.Customer;

import java.util.List;

public interface CustomerService {

    //create
    public Customer addCustomer(Customer customer);

    //get
    public List<Customer> getCustomers();

    public Customer getCustomerById(Long customer_id);

    //delete
    public void deleteCustomer(Long customer_id);

    //edit
    public Customer editCustomer(Long customer_id, Customer customer);


    //Add Cart

    public void addCartToCustomer(Long customer_id,Long cart_id);

}
