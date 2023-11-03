package com.kubudirira.ecrudv1.repository;



import com.kubudirira.ecrudv1.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long>  {
}
