package sevice.user;

import config.Config;
import model.User;

import java.util.List;

public class UserServiceIMPL implements IUserService {
    public static String PATH_USER = "C:\\Users\\WINDOWS\\IdeaProjects\\untitled28\\src\\database\\user.txt";
    public static List<User> userList = new Config<User>().readFile(PATH_USER);

    @Override
    public List<User> findAll() {
        new Config<User>().writeFile(PATH_USER, userList);
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public boolean existedByUserName(String userName) {
        for (int i = 0; i < userList.size(); i++) {
            if (userName.equals(userList.get(i).getName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existedByEmail(String email) {
        for (int i = 0; i < userList.size(); i++) {
            if (email.equals(userList.get(i).getEmail())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkLogin(String userName, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (userName.equals(userList.get(i).getUsername())&& password.equals(userList.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByUserName(String userName) {
        for (int i = 0; i < userList.size(); i++) {
            if (userName.equals(userList.get(i).getUsername())){
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public User getcurrentuser() {
        if (new Config<User>().readFile(Config.PATH_USER_PRIN) != null){
            User user = new Config<User>().readFile(Config.PATH_USER_PRIN).get(0);
            return user;
        }
        return null;
    }


}
