package com.kubudirira.ecrudv1.controller;



import com.kubudirira.ecrudv1.models.Category;
import com.kubudirira.ecrudv1.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/Category")
public class CategoryController {


    private final CategoryService categoryService;

    //add category

    @PostMapping("/add")
    public ResponseEntity<Category> addShoppingCart(@RequestBody Category category){

        Category  category_added  =  categoryService.addCategory(category);
        return  new ResponseEntity<>(category_added, HttpStatus.ACCEPTED);

    }


    //get category list

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> getShoppingCarts(){
        List<Category> categories = categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    //get category by id

    @GetMapping("/get/{id}")
    public ResponseEntity<Category> getCustomer(@PathVariable Long id){
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    //delete category

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable  Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Category with id :  " + id + " Deleted", HttpStatus.OK);

    }

    //edit category

    @PostMapping("/edit/{id}")
    public ResponseEntity<Category> editCustomer(@PathVariable  Long id, @RequestBody Category category){
        Category category_edited =  categoryService.editCategory(id, category);
        return new ResponseEntity<>(category_edited, HttpStatus.OK);

    }

    //add product to category

    @PostMapping("/addProduct/{product_id}/{category_id}")
    public ResponseEntity<String> addProduct(@PathVariable Long product_id,
                                             @PathVariable Long category_id){

        categoryService.addProductToCategory(product_id,category_id);

        return new ResponseEntity<>("Product added to Category with id : " + category_id, HttpStatus.OK);
    }


    //delete product from category

    /* Try this by yourself
    * */




}
