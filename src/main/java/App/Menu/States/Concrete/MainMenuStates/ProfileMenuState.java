package App.Menu.States.Concrete.MainMenuStates;

import App.Menu.States.Abstract.State;
import App.Menu.States.Concrete.LoginMenuStates.InitialState;
import App.Menu.States.Concrete.ProfileMenuStates.ChangeProfileState;
import App.Menu.States.Concrete.ProfileMenuStates.DeleteProfileState;
import App.Menu.Context.HabitApp;
import App.Menu.UI.Elements.NumberOption;
import App.Menu.UI.MenuCreator;

public class ProfileMenuState extends State {
    public ProfileMenuState(HabitApp context) {
        super(context);
    }

    @Override
    public void handle() {
        MenuCreator profileMenu = new MenuCreator();
        profileMenu.addNumberOption(new NumberOption(1, "Редактирование профиля"));
        profileMenu.addNumberOption(new NumberOption(2, "Удаление профиля"));
        profileMenu.addNumberOption(new NumberOption(3, "Выйти из профиля"));
        profileMenu.addNumberOption(new NumberOption(4, "В главное меню"));

        profileMenu.renderAllOptions();

        int input = profileMenu.getOptionFromConsole();

        switch (input) {
            case 1 -> context.changeState(new ChangeProfileState(context));
            case 2 -> context.changeState(new DeleteProfileState(context));
            case 3 -> context.changeState(new InitialState(context));
            case 4 -> context.changeState(new MainMenuState(context));
        }
    }
}
