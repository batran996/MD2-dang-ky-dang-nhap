package view;

import config.Config;
import controller.UserController;
import dto.reponse.ResponseMessenger;
import dto.request.SignInDTO;
import dto.request.SingupDTO;
import model.Role;
import model.User;

import java.nio.charset.MalformedInputException;
import java.util.HashSet;
import java.util.Iterator;
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
        SingupDTO singupDTO = new SingupDTO(id, name, userName, email, password, strRloe);
        ResponseMessenger check_existed = userController.register(singupDTO);
        //IN RA MÀU CHO System.out -> màu vàng a e tìm hiểu thêm in màu khác nhé
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[33m";
        if (check_existed.getMessenger().equals("username_existed")) {
            System.err.println("The username is exited! Please try again!");
            formRegiter();
        } else if (check_existed.getMessenger().equals("email_existed")) {
            System.err.println("The email is exited! Please try again!");
            formRegiter();
        } else if (check_existed.getMessenger().equals("success")) {
            System.out.println(ANSI_YELLOW + "CREATE USER SUCCESS!!!!!" + ANSI_RESET);
            System.out.println("CHECK LIST => " + userController.showListUser());
//            new Main();
        }

    }

    public void showListUser() {
        System.out.println("====id=====name========userName=======avatar======status======role==");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println("===" + userList.get(i).getId() + "=====" + userList.get(i).getName() + "======" + userList.get(i).getUsername()
                    + "=========" + userList.get(i).getAvatar() + "=========" + userList.get(i).isStatus() + "======" + userList.get(i).getRoles());

        }
    }

    public void fromLogin() {
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

        ResponseMessenger messenger = userController.login(new SignInDTO(userName, password));
        if (messenger.getMessenger().equals("login_failed")) {
            System.out.println("LOGIN_FAILED!please check username or password");
            fromLogin();
        } else {
            profile();
        }
    }

    public void profile() {
        System.out.println("===========profile");
        User userLogin = userController.getCurrentUser();
        System.out.println("Well come " + userLogin.getName());
//        System.out.println("ROle; " + userLogin.getRoles());
        String roleUser = null;
        Iterator<Role> iterator = userLogin.getRoles().iterator();
        while (iterator.hasNext()) {
//            System.out.println(iterator.next().getName());
            roleUser = String.valueOf(iterator.next().getName());
        }

        System.out.println("2:LOG OUT");
        System.out.println("3:Back to menu");
        int chooosemenu = Config.scanner().nextInt();
        switch (chooosemenu) {
            case 2:
                new Config<User>().writeFile(Config.PATH_USER_PRIN, null);
                new Main();
                break;
            case 3:
                new Main();
                break;

        }
    }
}
