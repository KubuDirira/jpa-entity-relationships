package com.kubudirira.ecrudv1.controller;



import com.kubudirira.ecrudv1.models.Customer;
import com.kubudirira.ecrudv1.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/Customer")
public class CustomerController {


    private final CustomerService customerService;

    //add customer

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){

       Customer  customer_added  =  customerService.addCustomer(customer);
       return  new ResponseEntity<>(customer_added, HttpStatus.OK);

    }


    //get customer list

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    //get customer by id

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        Customer customers = customerService.getCustomerById(id);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    //delete customer

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable  Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer with id :  " + id + " Deleted", HttpStatus.OK);

    }

    //edit customer

    @PostMapping("/edit/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable  Long id, @RequestBody Customer customer){
        Customer customer_edited =  customerService.editCustomer(id, customer);
        return new ResponseEntity<>(customer_edited, HttpStatus.OK);

    }

    @PostMapping("/addCart/{cart_id}/{customer_id}")
    public ResponseEntity<String> addCart(@PathVariable  Long cart_id,
                                          @PathVariable  Long customer_id){

        customerService.addCartToCustomer(customer_id,cart_id);


        return new ResponseEntity<>("Customer assigned  to Shopping " +
                "Cart with id : " + cart_id, HttpStatus.OK);

    }

}
