package view;

import config.Config;
import controller.UserController;
import dto.request.SingupDTO;
import model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class ViewUser {
    UserController userController = new UserController();
    List<User> userList = userController.showListUser();

    public ViewUser() {

    }

    public void formRegiter() {
        System.out.println("***********FORM REGISTER**********");
        int id;
        if (userList.size() == 0) {
            id = 1;
        } else {
            id = userList.get(userList.size() - 1).getId() + 1;

        }
///////////Name
        String name;
        boolean valiDateName;
        while (true) {
            System.out.println("Enter The Name");
            name = Config.scanner().nextLine();
            valiDateName = Pattern.matches("[A-Z][a-zA-Z[\\s]]{1,10}", name);
            if (valiDateName) {
                break;
            } else {
                System.err.println("The name failed! try again");
            }

        }
        /// user Name
        String userName;
        boolean valiDateUserName;
        while (true) {
            System.out.println("Enter The UserName");
            userName = Config.scanner().nextLine();
            valiDateUserName = Pattern.matches("[a-zA-Z0-9]{1,40}", userName);
            if (valiDateUserName) {
                break;
            } else {
                System.err.println("The name failed! try again");
            }
        }
        //////////////Email
        String email;
        boolean valiDateEmail;
        while (true) {
            System.out.println("Enter The Email");
            email = Config.scanner().nextLine();
            valiDateEmail = Pattern.matches("^(.+)@(.+)$", email);
            if (valiDateEmail) {
                break;
            } else {
                System.err.println("The name failed! try again");
            }
        }
/////////////////password///////////
        String password;
        boolean valiDatePassword;
        while (true) {
            System.out.println("Enter The Password");
            password = Config.scanner().nextLine();
            valiDatePassword = Pattern.matches("[a-zA-Z0-9]{1,40}", password);
            if (valiDatePassword) {
                break;
            } else {
                System.err.println("The name failed! try again");
            }
        }
        /////Role////////
        System.out.println("Enter The Role");
        String role = Config.scanner().nextLine();
        Set<String> strRloe = new HashSet<>();
        strRloe.add(role);
        SingupDTO singupDTO = new SingupDTO(id,name,userName,email,password,strRloe);
        if (userController.register(singupDTO).getMessenger().equals("username_existed")){
            System.err.println("the username is existed!Please try again");
        } else if (userController.register(singupDTO).getMessenger().equals("email_existed")) {
            System.err.println("the email is existed!Please try again");
        } else if (userController.register(singupDTO).getMessenger().equals("success")) {
            System.out.println("create success");
            System.out.println("check list" + userController.showListUser());
        }


    }


}
