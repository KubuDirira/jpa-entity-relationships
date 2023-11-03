package com.kubudirira.ecrudv1.services;



import com.kubudirira.ecrudv1.models.Product;

import java.util.List;

public interface ProductService {

    //create
    public Product addProduct(Product product);

    //get
    public List<Product> getProducts();

    public Product getProductById(Long product_id);


    //delete
    public void deleteProduct(Long product_id);


    //edit
    public Product editProduct(Long product_id, Product product);




}
