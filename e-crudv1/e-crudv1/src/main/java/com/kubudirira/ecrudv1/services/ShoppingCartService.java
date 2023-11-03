package com.kubudirira.ecrudv1.services;



import com.kubudirira.ecrudv1.models.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    //create
    public ShoppingCart addShoppingCart(ShoppingCart shoppingCart);

    //get
    public List<ShoppingCart> getShoppingCarts();

    public ShoppingCart getShoppingCartById(Long shopping_cart_id);

    //delete
    public void deleteShoppingCart(Long shopping_cart_id);

    //edit
    public ShoppingCart editShoppingCart(Long shopping_cart_id, ShoppingCart shoppingCart);


    //AddCategoryToProduct
    public void addProductToShoppingCart(Long product_id, Long shopping_cart_id);
    public void deleteProductFromShoppingCart(Long product_id, Long shopping_cart_id);

}
