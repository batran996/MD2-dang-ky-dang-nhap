package controller;

import dto.reponse.ResponseMessenger;
import dto.request.SingupDTO;
import model.Role;
import model.RoleName;
import model.User;
import sevice.role.IRoleService;
import sevice.role.RoleServiceIMPL;
import sevice.user.IUserService;
import sevice.user.UserServiceIMPL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserController {
    private final IUserService userService = new UserServiceIMPL();
    private IRoleService roleService = new RoleServiceIMPL();


    public List<User> showListUser(){
        return userService.findAll();
    }
public ResponseMessenger register(SingupDTO singupDTO){
        if (userService.existedByUserName(singupDTO.getUserName())){
            return new ResponseMessenger("user name_existed");
        }
        if (userService.existedByEmail(singupDTO.getEmail())){
            return new ResponseMessenger("email_existed");
        }
    Set<String> strRoles = singupDTO.getStrRoles();
        Set<Role> roles = new HashSet<>();
       strRoles.forEach(role->{
           switch (role){
               case "admin":
                   Role admindRole = roleService.findByName(RoleName.ADMIN);
                   roles.add(admindRole);
                   break;
               case "pm":
                   Role pmRole = roleService.findByName(RoleName.PM);
                   roles.add(pmRole);
                   break;
               default:
                   Role userRole = roleService.findByName(RoleName.USER);
                   roles.add(userRole);

           }
       });
       User user = new User(singupDTO.getId(), singupDTO.getName(), singupDTO.getUserName(),
               singupDTO.getEmail(), singupDTO.getPassword(), roles);
       showListUser();
       return new ResponseMessenger("success");

}



}
