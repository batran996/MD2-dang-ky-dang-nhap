package sevice.user;

import model.User;
import sevice.IGernericService;

public interface IUserService extends IGernericService<User> {
    boolean existedByUserName(String userName);

    boolean existedByEmail(String email);

    boolean checkLogin(String userName, String password);

    User findByUserName(String userName);
    User getcurrentuser();



}
