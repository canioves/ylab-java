package App.Menu.States.Concrete.LoginMenuStates;

import App.Menu.States.Abstract.State;
import App.Menu.Context.HabitApp;
import App.Menu.UI.Elements.NumberOption;
import App.Menu.UI.MenuCreator;

public class InitialState extends State {
    public InitialState(HabitApp context) {
        super(context);
    }

    @Override
    public void handle() {
        MenuCreator authMenu = new MenuCreator();
        authMenu.addNumberOption(new NumberOption(1, "Регистрация"));
        authMenu.addNumberOption(new NumberOption(2, "Вход"));
        authMenu.addNumberOption(new NumberOption(3, "Выйти из приложения"));

        authMenu.renderAllOptions();

        int choose = authMenu.getOptionFromConsole();

        switch (choose) {
            case 1 -> context.changeState(new RegisterState(context));
            case 2 -> context.changeState(new LoginState(context));
            case 3 -> System.exit(0);
        }
    }
}
