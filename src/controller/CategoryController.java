package controller;

import model.Category;
import sevice.category.CategoryIMPL;
import sevice.category.ICategoryService;

import java.util.List;

public class CategoryController {
    private ICategoryService categoryService = new CategoryIMPL();
    public List<Category> showListCategory(){
        return categoryService.findAll();
    }
    public void createCategory(Category category){
        categoryService.save(category);
    }

}
