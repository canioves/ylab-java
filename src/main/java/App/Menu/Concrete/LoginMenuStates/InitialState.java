package App.Menu.Concrete.LoginMenuStates;

import App.Menu.Abstract.State;
import App.Menu.HabitApp;
import App.Menu.UI.MenuCreator;

public class InitialState extends State {
    public InitialState(HabitApp context) {
        super(context);
    }

    @Override
    public void handle() {
        MenuCreator authMenu = new MenuCreator();
        authMenu.addOption(1, "Регистрация");
        authMenu.addOption(2, "Вход");
        authMenu.addOption(3, "Выход из приложения");
        authMenu.render();

        int input = authMenu.getInput();

        switch (input) {
            case 1 -> context.changeState(new RegisterState(context));
            case 2 -> context.changeState(new LoginState(context));
            case 3 -> System.exit(0);
        }
    }
}
