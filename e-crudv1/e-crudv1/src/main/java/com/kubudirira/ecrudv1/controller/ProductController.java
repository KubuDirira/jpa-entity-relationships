package com.kubudirira.ecrudv1.controller;



import com.kubudirira.ecrudv1.models.Product;
import com.kubudirira.ecrudv1.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    //add product

    @PostMapping("/add")
    public ResponseEntity<Product> addShoppingCart(@RequestBody Product product){

        Product  product_added  =  productService.addProduct(product);
        return  new ResponseEntity<>(product_added, HttpStatus.ACCEPTED);

    }


    //get product list

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getShoppingCarts(){
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    //get product by id

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getCustomer(@PathVariable Long id){
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    //delete product

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable  Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product with id :  " + id + " Deleted", HttpStatus.OK);

    }

    //edit product

    @PostMapping("/edit/{id}")
    public ResponseEntity<Product> editCustomer(@PathVariable  Long id, @RequestBody Product product){
        Product product_edited =  productService.editProduct(id, product);
        return new ResponseEntity<>(product_edited, HttpStatus.OK);

    }


}
