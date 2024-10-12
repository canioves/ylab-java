package App.Menu.States.Concrete.MainMenuStates;

import App.Menu.States.Abstract.State;
import App.Menu.Context.HabitApp;
import App.Menu.UI.Elements.NumberOption;
import App.Menu.UI.MenuCreator;

public class MainMenuState extends State {
    public MainMenuState(HabitApp context) {
        super(context);
    }

    @Override
    public void handle() {
        MenuCreator mainMenu = new MenuCreator();
        mainMenu.addNumberOption(new NumberOption(1, "Управление привычками"));
        mainMenu.addNumberOption(new NumberOption(2, "Управление профилем"));
        mainMenu.addNumberOption(new NumberOption(3, "Выйти из приложения"));

        mainMenu.renderAllOptions();

        int input = mainMenu.getOptionFromConsole();

        switch (input) {
            case 1 -> System.exit(0);
            case 2 -> context.changeState(new ProfileMenuState(context));
            case 3 -> System.exit(0);
        }
    }
}
