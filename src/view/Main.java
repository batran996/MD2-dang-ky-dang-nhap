package view;

import config.Config;
import controller.UserController;
import model.User;
import sevice.role.RoleServiceIMPL;

import javax.swing.text.View;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        UserController userController = new UserController();
        User user = userController.getCurrentUser();
        new RoleServiceIMPL().findAll();
//        System.out.println(new RoleServiceIMPL().findAll());
        new RoleServiceIMPL().findAll();
        System.out.println(new RoleServiceIMPL().findAll());
        System.out.println("1.Register");
        System.out.println("2.Login");
        System.out.println("3.Show list user");
        System.out.println("4.Show profile");
        System.out.println("5.Create Category");
        System.out.println("6.Show list category");

        int chooseMenu = Config.scanner().nextInt();
        switch (chooseMenu){
            case 1:
                new ViewUser().formRegiter();
                break;
            case 2:
                new ViewUser().fromLogin();
                break;
            case 3:
                new ViewUser().showListUser();
                break;
            case 4:
                new ViewUser().profile();
                break;
            case 5:
                new ViewCategory().formCreateCategory();
                break;
//            case 6:
////                new ViewCategory().l();
//                break;
        }
        new Main();
    }
}