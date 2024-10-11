package App.Menu.Concrete.LoginMenuStates;

import App.Menu.Abstract.State;
import App.Menu.Concrete.MainMenuStates.MainMenuState;
import App.Menu.HabitApp;
import App.Models.User;

import java.util.Scanner;

public class RegisterState extends State {

    public RegisterState(HabitApp context) {
        super(context);
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Имя пользователя: ");
        String userName = scanner.nextLine();
        System.out.println("Емайл: ");
        String email = scanner.nextLine();
        System.out.println("Пароль: ");
        String password = scanner.nextLine();

        User newUser = this.context.userController.register(userName, email, password);

        this.context.setUser(newUser);
        this.context.changeState(new MainMenuState(context));
    }
}