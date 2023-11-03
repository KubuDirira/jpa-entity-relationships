package com.kubudirira.ecrudv1.repository;


import com.kubudirira.ecrudv1.models.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart,Long> {
}
