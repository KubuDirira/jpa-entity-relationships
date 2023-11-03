package com.kubudirira.ecrudv1.services.implementation;


import com.kubudirira.ecrudv1.models.Customer;
import com.kubudirira.ecrudv1.models.ShoppingCart;
import com.kubudirira.ecrudv1.repository.CustomerRepository;
import com.kubudirira.ecrudv1.repository.ShoppingCartRepository;
import com.kubudirira.ecrudv1.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ShoppingCartRepository shoppingCartRepository;


    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customer_id) {
        return customerRepository.findById(customer_id).get();
    }

    @Override
    public void deleteCustomer(Long customer_id) {
         customerRepository.deleteById(customer_id);
    }

    @Override
    public Customer editCustomer(Long customer_id, Customer customer) {

        //find a customer

        Customer customer_found = customerRepository.findById(customer_id).get();

        //edit customer

        customer_found.setName(customer.getName());

        //save customer and return it.

        return  customerRepository.save(customer_found);
    }

    @Override
    public void addCartToCustomer(Long customer_id, Long cart_id) {

        //find a customer
        Customer customer = customerRepository.findById(customer_id).get();

        //find a shopping cart
        ShoppingCart shoppingCart =  shoppingCartRepository.findById(cart_id).get();

        //assign customer cart
        customer.setShoppingCart(shoppingCart);

        //save

        customerRepository.save(customer);


    }


}
