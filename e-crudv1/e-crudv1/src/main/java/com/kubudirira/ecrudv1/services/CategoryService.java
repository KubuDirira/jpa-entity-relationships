package com.kubudirira.ecrudv1.services;


import com.kubudirira.ecrudv1.models.Category;

import java.util.List;

public interface CategoryService {

    //create
    public Category addCategory(Category category);
    //get
    public List<Category> getCategories();

    public Category getCategoryById(Long category_id);

    //delete
    public void deleteCategory(Long category_id);

    //edit
    public Category editCategory(Long category_id, Category category);


    //AddCategoryToProduct
    public void addProductToCategory(Long product_id, Long category_id);
    public void deleteProductFromCategory(Long product_id, Long category_id);
}
