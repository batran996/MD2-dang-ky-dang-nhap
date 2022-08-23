package view;

import config.Config;
import controller.CategoryController;
import model.Category;

import java.util.ArrayList;
import java.util.List;

public class ViewCategory {
    private CategoryController categoryController = new CategoryController();
    List<Category>categoryList = categoryController.showListCategory();

    public void formCreateCategory(){
        int id;
        if (categoryList.size() ==0){
            id = 1;
        }else {
            id = categoryList.get(categoryList.size()-1).getId()+1;
        }
        System.out.println("Enter the name category");
        String name = Config.scanner().nextLine();
        Category category = new Category(id,name);
        categoryController.createCategory(category);
        System.out.println("list category " + categoryList);
    }
}
