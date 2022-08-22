package view;

import config.Config;
import sevice.role.RoleServiceIMPL;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
//        System.out.println(new RoleServiceIMPL().findAll());
        new RoleServiceIMPL().findAll();
        System.out.println(new RoleServiceIMPL().findAll());
        System.out.println("1.Register");
        int chooseMenu = Config.scanner().nextInt();
        switch (chooseMenu){
            case 1:
                new ViewUser().formRegiter();
                break;
        }
    }
}