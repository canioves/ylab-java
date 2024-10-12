package App.Menu.States.Concrete.LoginMenuStates;

import App.Menu.States.Abstract.State;
import App.Menu.States.Concrete.MainMenuStates.MainMenuState;
import App.Menu.Context.HabitApp;
import App.Menu.UI.Elements.InputField;
import App.Menu.UI.MenuCreator;


public class LoginState extends State {

    public LoginState(HabitApp context) {
        super(context);
    }

    @Override
    public void handle() {
        MenuCreator loginForm = new MenuCreator();
        loginForm.addInputField(new InputField("email", "Email: "));
        loginForm.addInputField(new InputField("password", "Пароль: "));

        loginForm.processAllInputFields();

        String email = loginForm.getInputFieldValue("email");
        String password = loginForm.getInputFieldValue("password");

        try {
            this.context.loginUser(email, password);
            this.context.changeState(new MainMenuState(context));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            this.context.changeState(new InitialState(context));
        }
    }
}