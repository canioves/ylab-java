package App.Menu.States.Concrete.ProfileMenuStates;

import App.Menu.States.Abstract.State;
import App.Menu.States.Concrete.LoginMenuStates.InitialState;
import App.Menu.States.Concrete.MainMenuStates.ProfileMenuState;
import App.Menu.Context.HabitApp;
import App.Menu.UI.Elements.TrueFalseOption;
import App.Menu.UI.MenuCreator;

public class DeleteProfileState extends State {
    public DeleteProfileState(HabitApp context) {
        super(context);
    }

    @Override
    public void handle() {
        MenuCreator deleteProfileMenu = new MenuCreator();
        deleteProfileMenu.addTrueFalseOption(new TrueFalseOption("delete",
            "Вы уверены, что хотите удалить текущий профиль?", "y", "n"));

        deleteProfileMenu.renderTrueFalseOption("delete");
        deleteProfileMenu.setTrueFalseOptionValue("delete");

        try {
            boolean choose = deleteProfileMenu.getTrueFalseOptionValue("delete");
            if (choose) {
                this.context.deleteUser();
                System.out.println("Текущий пользователь удален");
                this.context.changeState(new InitialState(context));
            } else {
                this.context.changeState(new ProfileMenuState(context));
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            this.context.changeState(new DeleteProfileState(context));
        }
    }
}
