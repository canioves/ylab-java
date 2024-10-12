package App.Menu.States.Concrete.ProfileMenuStates;

import App.Menu.States.Abstract.State;
import App.Menu.States.Concrete.MainMenuStates.MainMenuState;
import App.Menu.Context.HabitApp;
import App.Menu.UI.Elements.InputField;
import App.Menu.UI.MenuCreator;

public class ChangeProfileState extends State {
    public ChangeProfileState(HabitApp context) {
        super(context);
    }

    @Override
    public void handle() {
        System.out.println("Если изменения не требуются, нажмите Enter...");

        MenuCreator changeProfileForm = new MenuCreator();
        changeProfileForm.addInputField(new InputField("userName", "Введите новый логин: "));
        changeProfileForm.addInputField(new InputField("email", "Введите новый email: "));
        changeProfileForm.addInputField(new InputField("password", "Введите новый пароль: "));

        changeProfileForm.processAllInputFields();

        String newUserName = changeProfileForm.getInputFieldValue("userName");
        String newEmail = changeProfileForm.getInputFieldValue("email");
        String newPassword = changeProfileForm.getInputFieldValue("password");

        this.context.updateUser(newUserName, newEmail, newPassword);
        this.context.changeState(new MainMenuState(context));
    }
}
