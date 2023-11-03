package com.kubudirira.ecrudv1.services.implementation;


import com.kubudirira.ecrudv1.models.Product;
import com.kubudirira.ecrudv1.repository.ProductRepository;
import com.kubudirira.ecrudv1.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServeImpl implements ProductService {


    private final ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(Long product_id) {
        return productRepository.findById(product_id).get();
    }

    @Override
    public void deleteProduct(Long product_id) {
            productRepository.deleteById(product_id);
    }

    @Override
    public Product editProduct(Long product_id, Product product) {

        //find a product
       Product product_found = productRepository.findById(product_id).get();

       //edit product
        product_found.setName(product.getName());


        //save product and return it.
        return productRepository.save(product_found);
    }
}
