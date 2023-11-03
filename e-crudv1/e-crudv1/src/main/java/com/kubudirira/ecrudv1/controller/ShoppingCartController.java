package com.kubudirira.ecrudv1.controller;



import com.kubudirira.ecrudv1.models.ShoppingCart;
import com.kubudirira.ecrudv1.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/ShoppingCart")
public class ShoppingCartController {


    private final ShoppingCartService shoppingCartService;

    //add customer

    @PostMapping("/add")
    public ResponseEntity<ShoppingCart> addShoppingCart(@RequestBody ShoppingCart shoppingCart){

        ShoppingCart  shoppingCart_added  =  shoppingCartService.addShoppingCart(shoppingCart);
        return  new ResponseEntity<>(shoppingCart_added, HttpStatus.OK);

    }


    //get customer list

    @GetMapping("/getAll")
    public ResponseEntity<List<ShoppingCart>> getShoppingCarts(){
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCarts();
        return new ResponseEntity<>(shoppingCarts, HttpStatus.OK);
    }


    //get customer by id

    @GetMapping("/get/{id}")
    public ResponseEntity<ShoppingCart> getCustomer(@PathVariable Long id){
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(id);
        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }


    //delete customer

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable  Long id){
        shoppingCartService.deleteShoppingCart(id);
        return new ResponseEntity<>("ShoppingCart with id :  " + id + " Deleted", HttpStatus.OK);

    }

    //edit customer

    @PostMapping("/edit/{id}")
    public ResponseEntity<ShoppingCart> editCustomer(@PathVariable  Long id, @RequestBody ShoppingCart shoppingCart){
        ShoppingCart shoppingCart_edited =  shoppingCartService.editShoppingCart(id, shoppingCart);
        return new ResponseEntity<>(shoppingCart_edited, HttpStatus.OK);

    }

    //add product to the shopping cart

    @PostMapping("/addProduct/{product_id}/{shoppingCart_id}")
    public ResponseEntity<String> addProduct(@PathVariable Long product_id,
                                             @PathVariable Long shoppingCart_id){

        shoppingCartService.addProductToShoppingCart(product_id,shoppingCart_id);

        return new ResponseEntity<>("Product with id : " + product_id + "  added to Cart" ,  HttpStatus.OK);
    }

}
