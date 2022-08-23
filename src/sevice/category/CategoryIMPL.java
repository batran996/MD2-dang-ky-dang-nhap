package sevice.category;

import config.Config;
import model.Category;
import model.User;
import sevice.user.IUserService;
import sevice.user.UserServiceIMPL;

import java.util.List;

public class CategoryIMPL implements ICategoryService {
    private IUserService userService = new UserServiceIMPL();
    public static String PATH_CATEGORY = "C:\\Users\\WINDOWS\\IdeaProjects\\untitled28\\src\\database\\category.txt";
    public static List<Category> categoryList = new Config<Category>().readFile(PATH_CATEGORY);


    @Override
    public List<Category> findAll() {
        new Config<Category>().writeFile(PATH_CATEGORY, categoryList);
        return categoryList;
    }

    @Override
    public void save(Category category) {
        User user = userService.getcurrentuser();
        category.setUser(user);
        categoryList.add(category);
    }

}
