package App.Menu.Concrete.MainMenuStates;

import App.Menu.Abstract.State;
import App.Menu.HabitApp;
import App.Menu.UI.MenuCreator;

public class MainMenuState extends State {
    public MainMenuState(HabitApp context) {
        super(context);
    }

    @Override
    public void handle() {
        MenuCreator mainMenu = new MenuCreator();
        mainMenu.addOption(1, "Управление привычками");
        mainMenu.addOption(2, "Редактирование профиля");
        mainMenu.addOption(3, "Выйти из приложения");

        mainMenu.render();

        int input = mainMenu.getInput();

        switch (input) {
            case 1 -> System.exit(0);
            case 2 -> context.changeState(new ProfileMenuState(context));
            case 3 -> System.exit(0);
        }
    }
}
