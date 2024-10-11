package App.Menu.Concrete.LoginMenuStates;

import App.Menu.Abstract.State;
import App.Menu.Concrete.MainMenuStates.MainMenuState;
import App.Menu.HabitApp;
import App.Models.User;

import java.util.Scanner;

public class LoginState extends State {

    public LoginState(HabitApp context) {
        super(context);
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Емайл: ");
        String email = scanner.nextLine();
        System.out.println("Пароль: ");
        String password = scanner.nextLine();

        try {
            User existedUser = this.context.userController.login(email, password);
            this.context.setUser(existedUser);

            this.context.changeState(new MainMenuState(context));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            this.context.changeState(new InitialState(context));
        }
    }
}