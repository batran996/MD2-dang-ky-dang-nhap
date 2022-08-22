package sevice.role;

import config.Config;
import model.Role;
import model.RoleName;
import model.User;
import sevice.role.IRoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RoleServiceIMPL implements IRoleService {
//    public static String PATH_USER = "C:\\Users\\WINDOWS\\IdeaProjects\\untitled28\\src\\database\\user.txt";
//    public static List<User> userList = new Config<User>().readFile(PATH_USER);

    public static List<Role> roleList = new ArrayList<>();
    static {
        roleList.add(new Role(1,RoleName.USER));
        roleList.add(new Role(2,RoleName.PM));
        roleList.add(new Role(3,RoleName.ADMIN));
    }


    @Override
    public List<Role> findAll() {
        return roleList;
    }

    @Override
    public Role findByName(RoleName name) {
        for (int i = 0; i < roleList.size(); i++) {
            if (name == roleList.get(i).getName()){
                return roleList.get(i);
            }
        }
        return null;
    }
}
