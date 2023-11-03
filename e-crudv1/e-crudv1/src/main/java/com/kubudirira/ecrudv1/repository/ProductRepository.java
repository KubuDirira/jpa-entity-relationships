package com.kubudirira.ecrudv1.repository;



import com.kubudirira.ecrudv1.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
