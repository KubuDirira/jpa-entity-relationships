package com.kubudirira.ecrudv1.services.implementation;


import com.kubudirira.ecrudv1.models.Category;
import com.kubudirira.ecrudv1.models.Product;
import com.kubudirira.ecrudv1.repository.CategoryRepository;
import com.kubudirira.ecrudv1.repository.ProductRepository;
import com.kubudirira.ecrudv1.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;


    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long category_id) {
        return categoryRepository.findById(category_id).get();
    }

    @Override
    public void deleteCategory(Long category_id) {

        categoryRepository.deleteById(category_id);
    }

    @Override
    public Category editCategory(Long category_id, Category category) {


        //find a category to edit

        Category category_found = categoryRepository.findById(category_id).get();

        //edit

        category_found.setName(category.getName());

        //save and return it

        return categoryRepository.save(category_found);
    }














    @Override
    public void addProductToCategory(Long product_id, Long category_id) {

        //find a product
        Product product = productRepository.findById(product_id).get();
        //find a category
        Category category = categoryRepository.findById(category_id).get();
        //find a product list
        List<Product> products = category.getProducts();
        //add a product to the list
        products.add(product);
        category.setProducts(products);
        //save
        categoryRepository.save(category);


    }

    @Override
    public void deleteProductFromCategory(Long product_id, Long category_id) {

        //find a product


        Product product = productRepository.findById(product_id).get();

        //find a category


        Category category = categoryRepository.findById(category_id).get();

        //find a product list

        List<Product> products = category.getProducts();

        //add a product to the list

        products.remove(product);


        category.setProducts(products);
        //save

        categoryRepository.save(category);


    }
}
