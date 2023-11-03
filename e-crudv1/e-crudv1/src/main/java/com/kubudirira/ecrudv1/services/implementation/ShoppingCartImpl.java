package com.kubudirira.ecrudv1.services.implementation;


import com.kubudirira.ecrudv1.models.Product;
import com.kubudirira.ecrudv1.models.ShoppingCart;
import com.kubudirira.ecrudv1.repository.ProductRepository;
import com.kubudirira.ecrudv1.repository.ShoppingCartRepository;
import com.kubudirira.ecrudv1.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingCartImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;
    @Override
    public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public List<ShoppingCart> getShoppingCarts() {
        return (List<ShoppingCart>) shoppingCartRepository.findAll();
    }

    @Override
    public ShoppingCart getShoppingCartById(Long shopping_cart_id) {
        return shoppingCartRepository.findById(shopping_cart_id).get();
    }

    @Override
    public void deleteShoppingCart(Long shopping_cart_id) {
            shoppingCartRepository.deleteById(shopping_cart_id);
    }

    @Override
    public ShoppingCart editShoppingCart(Long shopping_cart_id, ShoppingCart shoppingCart) {

        //find shopping cart

        ShoppingCart shoppingCart_found = shoppingCartRepository.findById(shopping_cart_id).get();

        //edit shopping cart

        shoppingCart_found.setName(shoppingCart.getName());

        //save and return shopping cart
        return shoppingCartRepository.save(shoppingCart_found);
    }

    @Override
    public void addProductToShoppingCart(Long product_id, Long shopping_cart_id) {

        //find a product
        Product product_found = productRepository.findById(product_id).get();

        //find a shopping cart
        ShoppingCart shoppingCart_found = shoppingCartRepository.findById(shopping_cart_id).get();

        //get products from shopping cart
        List<Product> products = shoppingCart_found.getProducts();

        products.add(product_found);

        shoppingCart_found.setProducts(products);
        //save shopping cart
        shoppingCartRepository.save(shoppingCart_found);

    }

    @Override
    public void deleteProductFromShoppingCart(Long product_id, Long shopping_cart_id) {

        //find a product to remove

        Product product_found = productRepository.findById(product_id).get();

        //find a shopping cart

        ShoppingCart shoppingCart_found = shoppingCartRepository.findById(shopping_cart_id).get();


        //get products from shopping cart

        List<Product> products = shoppingCart_found.getProducts();

        products.remove(product_found);

        shoppingCart_found.setProducts(products);


    }
}
